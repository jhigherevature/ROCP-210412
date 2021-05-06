package main;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.AccountType;
import model.Customer;

public class CustomerMenu extends Menu{
	Scanner userInput = new Scanner(System.in);
	model.bank bank = new model.bank();
	static Logger logger = LogManager.getLogger(CustomerMenu.class);
	boolean exit;
	
	public void runCustomerMenu(int userID) {
		while(!exit) {

			Customer CustomerApproved = bank.getApprovedCustomer(userID);
			Customer CustomerUnApproved = bank.getUnApprovedCustomer(userID);
			if (CustomerApproved==null) {
				printAppendedCustomerMenu(CustomerUnApproved);
				int choice = getInput(3);
				if (choice == 1) {
					performAction(3,CustomerUnApproved,userID,CustomerUnApproved);
				} else if(choice == 2) {
					CustomerUnApproved.setNullBalance();
					CustomerUnApproved.setNullAccountID();
					CustomerUnApproved.setNullAccountType();
					performAction(5,CustomerUnApproved,userID,CustomerUnApproved);
				} else if(choice == 3) {
					performAction(6,CustomerUnApproved,userID,CustomerUnApproved);
				} else if (choice == 0) {
					performAction(0,CustomerUnApproved,userID,CustomerUnApproved);
				}
					
				
			} else {
				
				printCustomerMenu(CustomerApproved);
				int choice = getInput(6);
				Customer Customer = CustomerApproved;
				performAction(choice, Customer, userID,CustomerUnApproved);
			}

		}
	}
	void printAppendedCustomerMenu(Customer Customer) {
		logger.info("Opening Customer Menu...");
		System.out.println("\n-------------------------------------------------------");
		for (int i = ((55-(Customer.getFirstname().length()+9))/2); i > 0; i--) {
			System.out.print(" ");
		}
		System.out.println("Welcome " + Customer.getFirstname() + "!");
		System.out.println("-------------------------------------------------------");
		printCustomerUnApprovedAccounts(Customer);
		System.out.println("\nPlease make a selection: ");
		System.out.println("[1] Apply for a New Account");
		System.out.println("[2] Manage Joint Accounts");
		System.out.println("[3] Check/Update Customer Information");
		System.out.println("[0] Log Out");
	}
	
	void printCustomerMenu(Customer Customer) {
		logger.info("Opening Customer Menu...");
		System.out.println("\n-------------------------------------------------------");
		for (int i = ((55-(Customer.getFirstname().length()+9))/2); i > 0; i--) {
			System.out.print(" ");
		}
		System.out.println("Welcome " + Customer.getFirstname() + "!");
		System.out.println("-------------------------------------------------------");
		printCustomerAccounts(Customer);
		System.out.println("\nPlease make a selection: ");
		System.out.println("[1] Make a Deposit");
		System.out.println("[2] Make a Withdrawl");
		System.out.println("[3] Apply a New Account");
		System.out.println("[4] Check Accounts Pending Approval");
		System.out.println("[5] Manage Joint Accounts");
		System.out.println("[6] Check/Update Customer Information");
		System.out.println("[0] Log Out");
	}
	
	void printCustomerAccounts(Customer Customer) {
		logger.info("Printing Customer accounts...");
		System.out.println("\nHere are the accounts that you have with us:\n");
		for (int i = 0; i < Customer.getAccountType().size(); i++) {
			System.out.println("     [" + (i+1) + "] " + Customer.getAccountType().get(i) + " #" + Customer.getAccountID().get(i) + ": $" + Customer.getBalance().get(i));
		}
		
	}
	
	void printCustomerUnApprovedAccounts(Customer Customer) {
		logger.info("Printing Customer accounts pending approval...");
		System.out.println("\nHere are the accounts that you have applied for and are pending approval:\n");
		for (int i = 0; i < Customer.getAccountType().size(); i++) {
			System.out.println("     [" + (i+1) + "] " + Customer.getAccountType().get(i) + " #" + Customer.getAccountID().get(i) + ": $" + Customer.getBalance().get(i));
		}
		
	}
	
	void printJointAccounts(Customer Customer) {
		logger.info("Printing accounts where Customer is a Joint User...");
		System.out.println("\nHere are the accounts that you are a Joint user:\n");
		for (int i = 0; i < Customer.getAccountType().size(); i++) {
			System.out.println("     [" + (i+1) + "] " + Customer.getAccountType().get(i) + " #" + Customer.getAccountID().get(i) + ": $" + Customer.getBalance().get(i));
		}
		
	}
	
	void performAction(int choice, Customer Customer, int userID, Customer UnApprovedCustomer123) {
		boolean valid;
		int accountID;
		switch(choice) {
		case 0:
			logger.info("Customer logging out of account...");
			System.out.println("\nLogging out...");
			exit = true;
			
			break;
		case 1:
			double depositAccountAmount = 0;
			
			logger.info("Customer starting deposit process...");
			
			System.out.println("\n-------------------------------------------------------");
			System.out.println("                    Making a Deposit       ");
			System.out.println("-------------------------------------------------------");
			System.out.println("\nWhich account would you like to deposit to?");
			printCustomerAccounts(Customer);
			System.out.println("     [0] Cancel Deposit");
			int depositChoice = getInput(Customer.getAccountType().size());
			if (depositChoice == 0) {
				logger.info("Customer cancelling deposit...");
				return;
			}
			logger.info("Customer choosing which Account to deposit to...");
			accountID = Customer.getAccountID().get(depositChoice-1);
			AccountType depositAccountType = Customer.getAccountType().get(depositChoice - 1);
			double depositAccountBalance = Customer.getBalance().get(depositChoice - 1);
			valid = false;
			logger.info("Getting user input on how much to deposit...");
			while (!valid) {
				while (true) {
					System.out.println("\nHow much would you like to deposit?");
					System.out.print("Enter amount: $");
				    try {
				        depositAccountAmount = Double.parseDouble(userInput.next());
				        break; // will only get to here if input was a double
				    } catch (NumberFormatException ignore) {
				        System.out.println("Invalid input, please only enter numbers...");
				    }
				}
				
				if (depositAccountAmount < 0) {
					System.out.println("You can not deposit a negative amount...");
				} else if (depositAccountAmount != bank.roundDouble(depositAccountAmount,2)) {
					System.out.println("You can not deposit a fraction of a cent...");
					System.out.println("Make sure you only use up to two decimals...");
				} else {
					valid = true;
				}
			}
			logger.info("Deposit successful...");
			bank.deposit(accountID, depositAccountType, depositAccountBalance, depositAccountAmount);

			break;
		case 2:
			logger.info("Customer starting withdrawl process...");
			double withdrawlAccountAmount = 0;
			System.out.println("\n-------------------------------------------------------");
			System.out.println("                  Making a Withdrawl       ");
			System.out.println("-------------------------------------------------------");
			System.out.println("\nWhich account would you like to withdrawl from?");
			printCustomerAccounts(Customer);
			System.out.println("     [0] Cancel Withdrawl");
			int withdrawlChoice = getInput(Customer.getAccountType().size());
			if (withdrawlChoice == 0) {
				logger.info("Customer cancelling deposit process...");
				return;
			}
			logger.info("Customer selected account to withdrawl from...");
			accountID = Customer.getAccountID().get(withdrawlChoice-1);
			AccountType withdrawlAccountType = Customer.getAccountType().get(withdrawlChoice - 1);
			double withdrawlAccountBalance = Customer.getBalance().get(withdrawlChoice - 1);
			valid = false;
			logger.info("Customer selected ammount to withdrawl...");
			while (!valid) {
				while (true) {
					System.out.println("\nHow much would you like to withdrawl?");
					System.out.print("Enter amount: $");
				    try {
				        withdrawlAccountAmount = Double.parseDouble(userInput.next());
				        break; // will only get to here if input was a double
				    } catch (NumberFormatException ignore) {
				        System.out.println("Invalid input, please only enter numbers...");
				    }
				}
				if (withdrawlAccountAmount < 0) {
					System.out.println("You can not withdrawl a negative amount...");
				} else if (withdrawlAccountAmount != bank.roundDouble(withdrawlAccountAmount,2)) {
					System.out.println("You can not withdrawl a fraction of a cent...");
					System.out.println("Make sure you only use up to two decimals...");
				} else if (withdrawlAccountAmount > withdrawlAccountBalance){
					System.out.println("Insufficient funds...");
				} else {
					valid = true;
				}
		}
			logger.info("Withdrawl successful...");
			bank.withdrawl(accountID, withdrawlAccountType, withdrawlAccountBalance, withdrawlAccountAmount);

					
			break;
		case 3:	
			logger.info("Customer starting opening a new account process...");
			AccountType accountType = null;
			Double initialDeposit = null;
			System.out.println("\n-------------------------------------------------------");
			System.out.println("                 Opening a New Account     ");
			System.out.println("-------------------------------------------------------");
			System.out.println("\nWhich type of account would you like to open?");
			System.out.println("[1] Checking");
			System.out.println("[2] Savings");
			System.out.println("[0] Cancel Opening a New Account");
			int newAccountChoice = getInput(2);
			//System.out.println(newAccountChoice);
			if (newAccountChoice == 1) {
				accountType = AccountType.valueOf("Checking");
				valid = true;
			} else if (newAccountChoice == 2) {
				accountType = AccountType.valueOf("Savings");
				valid = true;
			} else if (newAccountChoice == 0) {
				return;
			}
			valid = false;
			while (!valid) {
				while (true) {
					System.out.println("\nWhat is your initial deposit?");
					System.out.print("Enter amount: $");
				    try {
				        initialDeposit = Double.parseDouble(userInput.next());
				        break; // will only get to here if input was a double
				    } catch (NumberFormatException ignore) {
				        System.out.println("Invalid input, please only enter numbers...");
				    }
				}
				if (initialDeposit < 0) {
					System.out.println("You can not deposit a negative amount...");
				} else if (initialDeposit != bank.roundDouble(initialDeposit,2)) {
					System.out.println("You can not deposit a fraction of a cent...");
					System.out.println("Make sure you only use up to two decimals...");
				} else if (accountType == AccountType.Checking) {
					if (initialDeposit < 100) {
						System.out.println("Checking Accounts require a minimum of $100 to open...");
					} else {
						valid = true;
					}
				} else if (accountType == AccountType.Savings) {
					if (initialDeposit < 50) {
						System.out.println("Savings Accounts require a minimum of $50 to open...");
					} else {
						valid = true;
					}
				}
			}
			logger.info("Customer created a new " + accountType.toString() + " account...");
			bank.openAccount(userID, accountType, initialDeposit);
			break;
		
		case 4:
			logger.info("Customer checking accounts pending approval...");
			System.out.println("\n-------------------------------------------------------");
			System.out.println("               Accounts Pending Approval               ");
			System.out.println("-------------------------------------------------------");
			if (UnApprovedCustomer123 == null) {
				System.out.println("You have no accounts pending approval...");
			} else {
				printCustomerUnApprovedAccounts(UnApprovedCustomer123);
			}
			break;
		
		case 5:
			logger.info("Customer starting joint account Manager...");
			System.out.println("\n-------------------------------------------------------");
			System.out.println("                 Joint Account Manager                 ");
			System.out.println("-------------------------------------------------------");
			Customer jointCustomer = bank.getJointAccounts(userID);
			
			if (jointCustomer == null) {
				System.out.println("You are not on a Secondary Account Holder.");
				addJointAccountManager(userID, Customer, jointCustomer);
			} else {
				printJointAccounts(jointCustomer);
				System.out.println("\nPlease make a selection: ");
				System.out.println("[1] Make a Deposit");
				System.out.println("[2] Make a Withdrawl");
				System.out.println("[3] Manage Joint Accounts");
				System.out.println("[0] Return to Customer Main Menu");
				int jointChoice = getInput(3);
				switch(jointChoice) {
				case 0:
					logger.info("Customer exiting Joint Account options...");
					System.out.println("\nReturning to Customer Main Menu");
					return;
					
				case 1:
					depositAccountAmount = 0;
					
					logger.info("Customer starting deposit process...");
					
					System.out.println("\n-------------------------------------------------------");
					System.out.println("                    Making a Deposit       ");
					System.out.println("-------------------------------------------------------");
					System.out.println("\nWhich account would you like to deposit to?");
					printJointAccounts(jointCustomer);
					System.out.println("     [0] Cancel Deposit");
					depositChoice = getInput(jointCustomer.getAccountType().size());
					if (depositChoice == 0) {
						logger.info("Customer cancelling deposit...");
						return;
					}
					logger.info("Customer choosing which Account to deposit to...");
					accountID = jointCustomer.getAccountID().get(depositChoice-1);
					depositAccountType = jointCustomer.getAccountType().get(depositChoice - 1);
					depositAccountBalance = jointCustomer.getBalance().get(depositChoice - 1);
					valid = false;
					logger.info("Getting user input on how much to deposit...");
					while (!valid) {
						while (true) {
							System.out.println("\nHow much would you like to deposit?");
							System.out.print("Enter amount: $");
						    try {
						        depositAccountAmount = Double.parseDouble(userInput.next());
						        break; // will only get to here if input was a double
						    } catch (NumberFormatException ignore) {
						        System.out.println("Invalid input, please only enter numbers...");
						    }
						}
						
						if (depositAccountAmount < 0) {
							System.out.println("You can not deposit a negative amount...");
						} else if (depositAccountAmount != bank.roundDouble(depositAccountAmount,2)) {
							System.out.println("You can not deposit a fraction of a cent...");
							System.out.println("Make sure you only use up to two decimals...");
						} else {
							valid = true;
						}
					}
					logger.info("Deposit successful...");
					bank.deposit(accountID, depositAccountType, depositAccountBalance, depositAccountAmount);

					break;
				case 2:
					logger.info("Customer starting withdrawl process...");
					withdrawlAccountAmount = 0;
					System.out.println("\n-------------------------------------------------------");
					System.out.println("                  Making a Withdrawl       ");
					System.out.println("-------------------------------------------------------");
					System.out.println("\nWhich account would you like to withdrawl from?");
					printJointAccounts(jointCustomer);
					System.out.println("     [0] Cancel Withdrawl");
					withdrawlChoice = getInput(jointCustomer.getAccountType().size());
					if (withdrawlChoice == 0) {
						logger.info("Customer cancelling deposit process...");
						return;
					}
					logger.info("Customer selected account to withdrawl from...");
					accountID = jointCustomer.getAccountID().get(withdrawlChoice-1);
					withdrawlAccountType = jointCustomer.getAccountType().get(withdrawlChoice - 1);
					withdrawlAccountBalance = jointCustomer.getBalance().get(withdrawlChoice - 1);
					valid = false;
					logger.info("Customer selected ammount to withdrawl...");
					while (!valid) {
						while (true) {
							System.out.println("\nHow much would you like to withdrawl?");
							System.out.print("Enter amount: $");
						    try {
						        withdrawlAccountAmount = Double.parseDouble(userInput.next());
						        break; // will only get to here if input was a double
						    } catch (NumberFormatException ignore) {
						        System.out.println("Invalid input, please only enter numbers...");
						    }
						}
						if (withdrawlAccountAmount < 0) {
							System.out.println("You can not withdrawl a negative amount...");
						} else if (withdrawlAccountAmount != bank.roundDouble(withdrawlAccountAmount,2)) {
							System.out.println("You can not withdrawl a fraction of a cent...");
							System.out.println("Make sure you only use up to two decimals...");
						} else if (withdrawlAccountAmount > withdrawlAccountBalance){
							System.out.println("Insufficient funds...");
						} else {
							valid = true;
						}
				}
					logger.info("Withdrawl successful...");
					bank.withdrawl(accountID, withdrawlAccountType, withdrawlAccountBalance, withdrawlAccountAmount);

					break;
				case 3:
					addJointAccountManager(userID, Customer, jointCustomer);
					break;
			}
			
			}
			break;
		
		case 6:
			logger.info("Customer starting updating Information process...");
			System.out.println("\n-------------------------------------------------------");
			System.out.println("             Updating Customer Information             ");
			System.out.println("-------------------------------------------------------");
			System.out.println("Here is your current information:");
			System.out.println("User Number: " + userID);
			System.out.println("First Name: " + Customer.getFirstname());
			System.out.println("Last Name: " + Customer.getLastname());
			System.out.println("Address: " + Customer.getAddress());
			System.out.println("\nWhich information would you like to update?");
			System.out.println("[1] First Name");
			System.out.println("[2] Last Name");
			System.out.println("[3] Address");
			System.out.println("[4] Username/Password");
			System.out.println("[0] Cancel Updating Information");
			int updateAccountChoice = getInput(4);
			switch(updateAccountChoice) {
			case 1:
				logger.info("Customer updating first name...");
				System.out.print("Input Your New First Name: ");
				String updatedFirstName = userInput.next();
				bank.updateFirstName(userID, updatedFirstName);
				break;
			case 2:
				logger.info("Customer updating last name...");
				System.out.print("Input Your New Last Name: ");
				String updatedLastName = userInput.nextLine();
				bank.updateLastName(userID, updatedLastName);
				break;
			case 3:
				logger.info("Customer updating address...");
				System.out.print("Input Your New Address: ");
				String updatedAddress = userInput.nextLine();
				bank.updateAddress(userID, updatedAddress);
				break;
			case 4:
				int userIDCheck = -1;
				logger.info("Customer updating Username/Password...");
				System.out.print("Input Your Current Username: ");
				String currentUsername = userInput.nextLine();
				System.out.print("Input Your Current Password: ");
				String currentPassword = userInput.nextLine();
				userIDCheck = bank.checkLoginInformation(currentUsername, currentPassword);
				if (userIDCheck > 0) {
					
				} else {
					System.out.println("Invalid login information, returning to Customer Menu...");
					logger.info("Customer provided incorrect username/password...");
					logger.info("Customer information update terminated...");

					return;
				}
				valid = false;
				String newUsername = currentUsername;
				while (!valid) {
					logger.info("Customer providing updated username/password...");
					System.out.println("Your new username can be the same as your current one");
					System.out.print("Input Your New Username: ");
					newUsername = userInput.nextLine();
					if (newUsername.length()>=5) {
						if (bank.usernameCheck(newUsername) == true) {
							valid = true;
						} else if (newUsername.equalsIgnoreCase("exit")) {
							System.out.println("Returning to Login Selection Menu...");
							return;
						} else if (newUsername.equals(currentUsername))
							valid = true;
						else {
							System.out.println(newUsername + " is already taken, please use a different login...");
							System.out.println("To exit updating the username/password, type [exit]...");
						}
					} else {
						System.out.println("Username must be at least 5 characters long");
					}
					
				}
				valid = false;
				String newPassword = null;
				while(!valid) {
					System.out.print("Please create a password: ");
					newPassword = userInput.nextLine();
					final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&])(?=.*\\d).+$");
					if (newPassword.length() >= 5) {
						if (textPattern.matcher(newPassword).matches()) {
							valid = true;
							
						} else {
							System.out.println("Password must contain at least one Uppercase Character, Lowercase Character, one number,");
							System.out.println("and one of the following characters :[! @ # $ % &]\n");
						}
					} else {
						System.out.println("Password must be at least 5 characters long ");
						System.out.println("and contain at least one Uppercase Character, Lowercase Character, one number,");
						System.out.println("and one of the following characters :[! @ # $ % &]\n");
					}
				}
				logger.info("Customer username and password updated...");
				bank.updateUsernamePassword(userIDCheck, newUsername, newPassword);
				
			case 0:
				logger.info("Customer cancelling updating information process...");
				return;
				
			}
			break;
		default:
			System.out.println("Unknown error has occurred..");	
		}
	

	
}
	private void addJointAccountManager(int userID, Customer Customer, Customer jointCustomer) {
		boolean valid = false;
		if (Customer.getAccountID()==null) {
			System.out.println("\nNone of your accounts are elgible to add a Secondary User");
			System.out.println("Returning to Customer Main Menu...");
			return;
		}
		while(!valid) {
			System.out.println("Would you like to add a Secondary Account Holder to one of your accounts?");
			System.out.println("[1] Yes");
			System.out.println("[0] No");
			int addJointCustomer = getInput(1);
			if (addJointCustomer == 0) {
				logger.info("Customer closing joint account Manager");
				valid = true;
			} else {
				boolean valid1 = false;
				while(!valid1) {
					System.out.println("Which account would you like to add a Secondary Account Holder to?");
					printCustomerAccounts(Customer);
					System.out.println("     [0] Cancel Deposit");
					int jointChoice = getInput(Customer.getAccountType().size());
					if (jointChoice == 0) {
						logger.info("Customer cancelling adding a Secondary Account Holder...");
						return;
					}
					logger.info("Customer choosing which Account to add a Secondary Account Holder to...");
					Integer accountID = Customer.getAccountID().get(jointChoice-1);
					
					if (bank.checkSAHExists(accountID) > 0) {
						System.out.println("User #" + bank.checkSAHExists(accountID) + " is the current Secondary Account Holder on Account #" + accountID);
						System.out.println("Would you like to change the Secondary Account Holder on Account # " + accountID +"?");
						System.out.println("[1] Yes");
						System.out.println("[0] No");
						int changeJointCustomer = getInput(1);
						if (changeJointCustomer == 0) {
							System.out.println("Cancelling adding a Secondary Account Holder...");
							return;
						} else {
							int jointUserID;
							boolean valid2 = false;
							while (!valid2) {
								while (true) {
									System.out.println("Enter the UserID of the Secondary Account Holder on Account #" + accountID +" that you would like to add: ");
								    try {
								        jointUserID = Integer.parseInt(userInput.next());
								        break; 
								    } catch (NumberFormatException ignore) {
								        System.out.println("Invalid input, please only enter numbers...");
								    }
								}
								if(bank.UserExists(jointUserID) == true) {
									if(jointUserID != userID) {
										bank.updateJointAccount(accountID, jointUserID);
										System.out.println("User ID #"+ jointUserID+ " added as a Secondary Account Holder...");
										return;
									} else {
										System.out.println("You entered your own ID, you cannot be a Secondary Account Holder on your own accounts...");
									}
							    } else {
							    	System.out.println("User ID # " + jointUserID + " does not exists...");
							    }
							}
						}
					} else {
						int jointUserID;
						boolean valid2 = false;
						while (!valid2) {
							while (true) {
								System.out.println("Enter the UserID of the Secondary Account Holder on Account #" + accountID +" that you would like to add: ");
							    try {
							        jointUserID = Integer.parseInt(userInput.next());
							        break; 
							    } catch (NumberFormatException ignore) {
							        System.out.println("Invalid input, please only enter numbers...");
							    }
							}
							if(bank.UserExists(jointUserID) == true) {
								if(jointUserID != userID) {
									bank.updateJointAccount(accountID, jointUserID);
									System.out.println("User ID #"+ jointUserID+ " added as a Secondary Account Holder...");
									return;
								} else {
									System.out.println("You entered your own ID, you cannot be a Secondary Account Holder on your own accounts...");
								}
						    } else {
						    	System.out.println("User ID # " + jointUserID + " does not exists...");
						    }
						}
					}		
				}
			}
		}
		
	}

	
	}
	
