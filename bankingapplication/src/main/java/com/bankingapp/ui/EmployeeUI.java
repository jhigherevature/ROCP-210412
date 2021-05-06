package com.bankingapp.ui;

import java.util.List;

import com.bankingapp.business.AccountService;
import com.bankingapp.business.BusinessException;
import com.bankingapp.business.CustomerService;
import com.bankingapp.business.EmployeeService;
import com.bankingapp.entities.Account;
import com.bankingapp.entities.Customer;
import com.bankingapp.entities.Employee;

public class EmployeeUI {

	private EmployeeService employeeService;
	private AccountService accountService;
	private CustomerService customerService;

	public EmployeeUI(EmployeeService employeeService, AccountService accountService, CustomerService customerService) {
		this.employeeService = employeeService;
		this.accountService = accountService;
		this.customerService = customerService;
	}

	public void logIn() {

		System.out.println("Enter userName");
		String userName = ScannerUtilities.getInputString();

		System.out.println("Enter password");
		String password = ScannerUtilities.getInputString();

		try {

			Employee employee = employeeService.findEmployee(userName, password);

			if (employee != null) {
				System.out.println("Log in successfully!");
				startEmployeeActivities(employee);
			} else {
				System.out.println("Log in failed! Try again");
				System.out.println();
				logIn();
			}

		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	private void startEmployeeActivities(Employee employee) throws BusinessException {
		boolean isAdmin = employee.getEmployeeRole().getRoleName().equals("Admin");
		loop: while (true) {
			int lastOption = 3;
			System.out.println("What will you like to do today, " + employee.getEmployeeName());
			System.out.println("1. Approve account application");
			System.out.println("2. View customer information");
			System.out.println("3. View account information");

			if (isAdmin) {
				System.out.println("4. Withdraw money from an account");
				System.out.println("5. Deposit money to an account");
				System.out.println("6. Transfer money between accounts");
				System.out.println("7. Cancel account");

				lastOption = 7;
			}
			lastOption++;
			System.out.println(lastOption + ". Exit");

			int userResponse = ScannerUtilities.getResponse(1, lastOption);

			switch (userResponse) {
			case 1:
				approveAccountApplication();
				break;
			case 2:
				viewCustomerInformation();
				break;
			case 3:
				viewAccountInformation();
				break;
			case 4:
				if (isAdmin)
					withdrawMoneyFromAccount();
				else {
					System.out.println("See you again soon, " + employee.getEmployeeName());
					break loop;
				}
				break;
			case 5:
				depositMoneyToAccount();
				break;
			case 6:
				transferMoneyBetweenAccounts();
				break;
			case 7:
				cancelAccount();
				break;
			case 8:
				System.out.println("See you again soon, " + employee.getEmployeeName());
				break loop;
			}
		}
	}

	private void cancelAccount() throws BusinessException {
		Account account = getAccount("Select account to cancel", accountService.findAllAccounts());

		if (account != null) {
			accountService.removeAccount(account);
		}
	}

	private void transferMoneyBetweenAccounts() throws BusinessException {
		List<Account> accounts = accountService.findAllAccounts();
		if (accounts.size() >= 2) {
			Account sourceAccount = getAccount("Which account would like to transfer money from?", accounts);

			Account targetAccount = getAccount("Which account would like to transfer money to?", accounts);
			
			if(!sourceAccount.getAccountNumber().equals(targetAccount.getAccountNumber())) {
				double amount = ScannerUtilities.getAmountOfMoney("How much money would you like to transfer?");

				double newSourceBalance = sourceAccount.getAccountBalance() - amount;
				if (newSourceBalance >= 0) {
					accountService.transferMoney(sourceAccount, targetAccount, null, amount);

					System.out.println(amount + " has successfully been transferred from "
							+ sourceAccount.getAccountNumber() + " to " + targetAccount.getAccountNumber());
				} else {
					System.out.println("Insufficient funds in the source account");
				}
			}else {
				System.out.println("You cannot transfer money from an account to itself. Try again");
				transferMoneyBetweenAccounts();
			}
		}else if(accounts.size() > 0){
			System.out.println("There is only 1 account in the system.  Transfer is not possible at this time");
		}
		else {
			System.out.println("There are no accounts in the system. Transfer is not possible at this time");
		}
	}

	private void depositMoneyToAccount() throws BusinessException {
		Account account = getAccount("Select account to deposit money into", accountService.findAllAccounts());

		if (account != null) {
			double amount = ScannerUtilities.getAmountOfMoney("How much money would you like to deposit?");

			accountService.depositMoney(account, null, amount);

			System.out.println(amount + " has successfully been credited to account " + account.getAccountNumber());
			System.out.println("The new balance is " + account.getAccountBalance());
		}
	}

	private void withdrawMoneyFromAccount() throws BusinessException {
		Account account = getAccount("Select account to withdraw money from", accountService.findAllAccounts());

		if (account != null) {
			System.out.println(
					"Account " + account.getAccountNumber() + " has " + account.getAccountBalance() + " remaining");
			double amount = ScannerUtilities.getAmountOfMoney("How much money would you like to withdraw?");

			double newBalance = account.getAccountBalance() - amount;
			if (newBalance >= 0) {
				accountService.depositMoney(account, null, amount);

				System.out.println(amount + " has successfully been credited to account " + account.getAccountNumber());
				System.out.println("The new balance is " + account.getAccountBalance());
			} else {
				System.out.println("You may not overdraw this account");
				System.out.println();
			}
		}
	}

	private void viewAccountInformation() throws BusinessException {

		Account account = getAccount("Select account to view its information", accountService.findAllAccounts());

		if (account != null) {
			System.out.print("Balance: " + account.getAccountBalance() + " ");
			System.out.print("Type: " + account.getAccountType().getAccountTypeName() + " ");
			System.out.print("Status: " + account.getStatus() + " ");
			System.out.println();
			System.out.println("Owned by:");

			List<Customer> customers = customerService.findCustomersBy(account);

			for (Customer customer : customers) {
				System.out.print("Name: " + customer.getCustomerName() + " ");
				System.out.print("Address: " + customer.getAddress() + " ");
				System.out.println("Email: " + customer.getEmail());
			}
			System.out.println();
		}
	}

	private Account getAccount(String prompt, List<Account> accounts) throws BusinessException {
		Account account = null;

		System.out.println(prompt);

		for (int i = 0; i < accounts.size(); i++) {
			int optionNumber = i + 1;
			System.out.println(optionNumber + ". " + accounts.get(i).getAccountNumber());
		}

		int cancelOption = accounts.size() + 1;
		System.out.println(cancelOption + ". Cancel this operation");

		int response = ScannerUtilities.getResponse(1, cancelOption);

		if (response != cancelOption)
			account = accounts.get(response - 1);

		return account;
	}

	private void viewCustomerInformation() throws BusinessException {
		List<Customer> customers = customerService.findAllCustomers();
		System.out.println("Select customer to view their information");

		for (int i = 0; i < customers.size(); i++) {
			int optionNumber = i + 1;
			System.out.println(optionNumber + ". " + customers.get(i).getCustomerName());
		}

		int cancelOption = customers.size() + 1;
		System.out.println(cancelOption + ". Cancel");

		int response = ScannerUtilities.getResponse(1, cancelOption);

		if (response == cancelOption)
			return;
		else {
			Customer customer = customers.get(response - 1);

			System.out.println("Name: " + customer.getCustomerName());
			System.out.println("Address: " + customer.getAddress());
			System.out.println("Email: " + customer.getEmail());
			System.out.println("Here are a list of accounts owned by " + customer.getCustomerName() + ":");

			List<Account> accounts = accountService.findAccountsOfCustomer(customer);

			for (Account account : accounts) {
				System.out.print("Account Number: " + account.getAccountNumber());
				System.out.print(" ");
				System.out.print("Balance: " + account.getAccountBalance());
				System.out.println();
			}
			System.out.println();
			viewCustomerInformation();
		}
	}

	private void approveAccountApplication() throws BusinessException {
		System.out.println();
		List<Account> accounts = accountService.findAllUnapprovedAccounts();
		if (accounts.size() > 0) {
			Account account = getAccount("Here are the current list of accounts pending approval. Select one",
					accounts);

			if (account != null) {

				System.out.println("What would you like to do?");
				System.out.println("1. approve account");
				System.out.println("2. deny account");

				int response = ScannerUtilities.getResponse(1, 2);
				String newAccountStatus = response == 1 ? "approved" : "denied";
				account.setStatus(newAccountStatus);

				accountService.updateAccount(account);
				approveAccountApplication();
			}
		} else {
			System.out.println("There are no accounts pending approval");
		}
	}
}
