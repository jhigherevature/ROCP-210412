package services;

import java.text.DecimalFormat;
import java.util.List;

import dao.AccountDAO;
import dao.CustomerAccountDAO;
import dao.TransactionDAO;
import model.Admin;
import model.Customer;
import model.Transaction;
import utilities.DAOUtility;
import utilities.ScannerUtility;

public class TransactionsService {
	ScannerUtility s = ScannerUtility.getInstance();
	TransactionDAO tdao = DAOUtility.getTransactionDAO();
	AccountDAO adao = DAOUtility.getAccountDAO();
	CustomerAccountDAO cdao = DAOUtility.getCustomerAccountDAO();
	TransactionMainMenuService menu = new TransactionMainMenuService();
	private static DecimalFormat df = new DecimalFormat("#.##");

	public void showAllTransactions(Customer customer) {
		List<Transaction> transactions = tdao.getTransanctionsByUser(customer.getUserID());
		if (transactions.size() < 1) {
			System.out.println("\nThere are no transactions to show at this time.");
		} else {
			transactions.forEach(transaction -> System.out.println("\nAccount ID: " + transaction.getAccountID()
					+ "\nTransaction type: " + transaction.getTransactionType() + "\nTransaction amount: $"
					+ df.format(transaction.getAmount()) + "\nTransaction time: " + transaction.getTimestamp()
					+ "\nTransaction ID: " + transaction.getTransactionID() + "\n-------------------"));
		}

		System.out.println("\nReturning to transaction menu...\n");
		menu.mainMenu(customer);

	}

	public void makeDeposit(Customer customer) {
		double balance;
		int accountID;
		double amount;
		int userID = customer.getUserID();
		int customerID = customer.getCustomerID();
		boolean customerAccount;
		boolean finished = false;
		int accountAttempts = 0;
		int amountAttempts = 0;

		do {
			System.out.print("\nWhich account would you like to make a deposit to? ");

			if (s.scan.hasNextInt()) {
				accountID = s.scan.nextInt();
				customerAccount = cdao.isCustomerAccount(customerID, accountID);
				if (customerAccount) {
					s.scan.nextLine();
					System.out.print(
							"\nPlease enter the deposit amount (negative numbers will be converted to positive): ");
					do {
						if (s.scan.hasNextInt() || s.scan.hasNextDouble()) {
							amount = (s.scan.hasNextInt()) ? (double) s.scan.nextInt() : s.scan.nextDouble();
							if (amount < 0) {
								amount *= -1;
							}

							balance = adao.getAccountBalance(accountID);
							tdao.makeDepositByAccountID(accountID, userID, amount);

							System.out.println("\n A deposit of $" + df.format(amount)
									+ " was made.\nYour new balance is $" + df.format((balance + amount)));
							finished = true;
							break;
						} else {
							s.scan.nextLine();
							amountAttempts++;
							System.out.print(
									"\n please enter a number. (" + (5 - amountAttempts) + " attempts remaining): ");
						}
					} while (amountAttempts <= 5);
				} else {
					s.scan.nextLine();
					accountAttempts++;
					System.out.print("\n please enter an account number that is yours. (" + (5 - accountAttempts)
							+ " attempts remaining): ");
				}
			} else {
				s.scan.nextLine();
				accountAttempts++;
				System.out.print(
						"\n please enter a valid account number. (" + (5 - accountAttempts) + " attempts remaining): ");

			}
		} while (!finished && accountAttempts <= 5);

		System.out.println("\nReturning to transaction menu...\n");
		menu.mainMenu(customer);

	}

	public void makeWithdrawal(Customer customer) {
		double balance;
		int accountID;
		double amount;
		int userID = customer.getUserID();
		int customerID = customer.getCustomerID();
		boolean customerAccount;
		boolean finished = false;
		int accountAttempts = 0;
		int amountAttempts = 0;

		do {
			System.out.print("\nWhich account would you like to make a withdrawal from? ");

			if (s.scan.hasNextInt()) {
				accountID = s.scan.nextInt();
				customerAccount = cdao.isCustomerAccount(customerID, accountID);
				if (customerAccount) {
					s.scan.nextLine();
					System.out.print(
							"\nPlease enter the withdrawal amount (positive numbers will be converted to negative): ");
					do {
						if (s.scan.hasNextInt() || s.scan.hasNextDouble()) {
							amount = (s.scan.hasNextInt()) ? (double) s.scan.nextInt() : s.scan.nextDouble();
							if (amount > 0) {
								amount *= -1;
							}

							balance = adao.getAccountBalance(accountID);
							if ((balance + amount) < 0) {
								s.scan.nextLine();
								System.out.print(
										"\n Amount would cause overdraft. Please enter an amount no greater than $. "
												+ df.format(balance));
								continue;
							}
							tdao.makeWithdrawalByAccountID(accountID, userID, amount);

							System.out.println("\n A withdrawal of $" + df.format((amount * -1))
									+ " was made.\nYour new balance is $" + df.format((balance + amount)));
							finished = true;
							break;
						} else {
							s.scan.nextLine();
							amountAttempts++;
							System.out.print(
									"\n please enter a number. (" + (5 - amountAttempts) + " attempts remaining): ");
						}
					} while (amountAttempts <= 5);
				} else {
					s.scan.nextLine();
					accountAttempts++;
					System.out.print("\n please enter an account number that is yours. (" + (5 - accountAttempts)
							+ " attempts remaining): ");
				}
			} else {
				s.scan.nextLine();
				accountAttempts++;
				System.out.print(
						"\n please enter a valid account number. (" + (5 - accountAttempts) + " attempts remaining): ");

			}
		} while (!finished && accountAttempts <= 5);

		System.out.println("\nReturning to transaction menu...\n");
		menu.mainMenu(customer);

	}

	public void showAllTransactions(Admin admin) {
		List<Transaction> transactions = tdao.getAllTransactions();
		if (transactions.size() < 1) {
			System.out.println("\nThere are no transactions to show at this time.");
		} else {
			transactions.forEach(transaction -> System.out
					.println("\nAccount ID: " + transaction.getAccountID() + "\nUser ID: " + transaction.getUserID()
							+ "\nTransaction type: " + transaction.getTransactionType() + "\nTransaction amount: $"
							+ df.format(transaction.getAmount()) + "\nTransaction time: " + transaction.getTimestamp()
							+ "\nTransaction ID: " + transaction.getTransactionID() + "\n-------------------"));
		}

		System.out.println("\nReturning to transaction menu...\n");
		menu.mainMenu(admin);

	}

	public void makeDeposit(Admin admin) {
		double balance;
		int accountID;
		double amount;
		int userID = admin.getUserID();
		boolean finished = false;
		int accountAttempts = 0;
		int amountAttempts = 0;

		do {
			System.out.print("\nWhich account would you like to make a deposit to? ");

			if (s.scan.hasNextInt()) {
				accountID = s.scan.nextInt();

				s.scan.nextLine();
				System.out
						.print("\nPlease enter the deposit amount (negative numbers will be converted to positive): ");
				do {
					if (s.scan.hasNextInt() || s.scan.hasNextDouble()) {
						amount = (s.scan.hasNextInt()) ? (double) s.scan.nextInt() : s.scan.nextDouble();
						if (amount < 0) {
							amount *= -1;
						}

						balance = adao.getAccountBalance(accountID);
						tdao.makeDepositByAccountID(accountID, userID, amount);

						System.out.println("\n A deposit of $" + df.format(amount) + " was made.\nThe new balance is $"
								+ df.format((balance + amount)));
						finished = true;
						break;
					} else {
						s.scan.nextLine();
						amountAttempts++;
						System.out
								.print("\n please enter a number. (" + (5 - amountAttempts) + " attempts remaining): ");
					}
				} while (amountAttempts < 5);
			} else {
				s.scan.nextLine();
				accountAttempts++;
				System.out.print(
						"\n please enter a valid account number. (" + (5 - accountAttempts) + " attempts remaining): ");

			}
		} while (!finished && accountAttempts < 5);

		System.out.println("\nReturning to transaction menu...\n");
		menu.mainMenu(admin);

	}

	public void makeWithdrawal(Admin admin) {
		double balance;
		int accountID;
		double amount;
		int userID = admin.getUserID();
		boolean finished = false;
		int accountAttempts = 0;
		int amountAttempts = 0;

		do {
			System.out.print("\nWhich account would you like to make a withdrawal from? ");

			if (s.scan.hasNextInt()) {
				accountID = s.scan.nextInt();

				s.scan.nextLine();
				System.out.print(
						"\nPlease enter the withdrawal amount (positive numbers will be converted to negative): ");
				do {
					if (s.scan.hasNextInt() || s.scan.hasNextDouble()) {
						amount = (s.scan.hasNextInt()) ? (double) s.scan.nextInt() : s.scan.nextDouble();
						if (amount > 0) {
							amount *= -1;
						}

						balance = adao.getAccountBalance(accountID);
						if ((balance + amount) < 0) {
							s.scan.nextLine();
							System.out
									.print("\n Amount would cause overdraft. Please enter an amount no greater than $. "
											+ df.format(balance));
							continue;
						}
						tdao.makeWithdrawalByAccountID(accountID, userID, amount);

						System.out.println("\n A withdrawal of $" + df.format((amount * -1))
								+ " was made.\nYour new balance is $" + df.format((balance + amount)));
						finished = true;
						break;
					} else {
						s.scan.nextLine();
						amountAttempts++;
						System.out
								.print("\n please enter a number. (" + (5 - amountAttempts) + " attempts remaining): ");
					}
				} while (amountAttempts < 5);
			} else {
				s.scan.nextLine();
				accountAttempts++;
				System.out.print(
						"\n please enter a valid account number. (" + (5 - accountAttempts) + " attempts remaining): ");

			}
		} while (!finished && accountAttempts < 5);

		System.out.println("\nReturning to transaction menu...\n");
		menu.mainMenu(admin);

	}

}
