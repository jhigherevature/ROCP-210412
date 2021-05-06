package main;

import java.util.Scanner;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.AccountType;


public class LoginMenu extends Menu{
	 Scanner userInput = new Scanner(System.in);
	 model.bank bank = new model.bank();
	 CustomerMenu cm = new CustomerMenu();
	 EmployeeMenu em = new EmployeeMenu();
	 AdminMenu am = new AdminMenu();
	 static Logger logger = LogManager.getLogger(LoginMenu.class);
	 boolean exit;
	 
	void runLoginMenu() {
		while(!exit) {
	        logger.info("Login menu opened...");
			printHeader();
			printLoginMenu();
			int choice = getInput(3);
			performAction(choice);
		}
	}
	
	void printHeader() {
		System.out.println("+-----------------------------------------------------+");
		System.out.println("|                  Welcome to Aron's                  |");
		System.out.println("|                     Banking App                     |");
		System.out.println("+-----------------------------------------------------+");
	}
	// Menu 1
	void printLoginMenu() {
		System.out.println("\n-------------------------------------------------------");
		System.out.println("                  Login Selection Menu                  ");
		System.out.println("-------------------------------------------------------");
		System.out.println("\nPlease make a selection: ");
		System.out.println("[1] Employee Login");
		System.out.println("[2] Customer Login");
		System.out.println("[3] New Customer");
		System.out.println("[0] Exit");
	}
	
	void performAction(int choice) {
		String username, password;
		 int userID;
		switch(choice) {
		case 0:
			logger.info("Closing application...");
			System.out.println("\nThank you for using Aron's banking application");
			System.exit(0);
			break;
		case 1:
			logger.info("Employee Login Menu opened...");
			System.out.println("\n-------------------------------------------------------");
			System.out.println("                     Employee Login                     ");
			System.out.println("-------------------------------------------------------");
			System.out.print("\nEmployee Username: ");
			username = userInput.nextLine();
			System.out.print("Employee Password: ");
			password = userInput.nextLine();
			String empID = bank.checkEmpLoginInformation(username, password);
			if (empID != null) {
				if (empID.equals("Employee")) {
					System.out.println("Successful login, retrieving information...");
					logger.info("An employee has successfully logged in...");
					em.exit=false;
					em.runEmployeeMenu();
				}
				if (empID.equals("Admin")) {
					System.out.println("Successful login, retrieving information...");
					logger.info("An admin has successfully logged in...");
					am.exit=false;
					am.runAdminMenu();
				}
				
			} else {  
				logger.info("Incorrect username/password...");
				System.out.println("Invalid login information, returning to Login Selection Menu...");
			}
			
			break;
		case 2:
			logger.info("Customer Login Menu opened...");
			System.out.println("\n-------------------------------------------------------");
			System.out.println("                     Customer Login                     ");
			System.out.println("-------------------------------------------------------");
			System.out.print("\nCustomer Username: ");
			username = userInput.nextLine();
			System.out.print("Customer Password: ");
			password = userInput.nextLine();
			userID = bank.checkLoginInformation(username, password);
			if (userID > 0) {
				System.out.println("Successful login, retrieving information...");
				cm.exit = false;
				logger.info("Customer #" + userID + " has successfully logged in...");
				cm.runCustomerMenu(userID);
			} else {
				System.out.println("Invalid login information, returning to Login Selection Menu...");
				logger.info("Incorrect username/password...");
			}
			
			break;
		case 3:	
			logger.info("New Customer Login Account Menu opened...");
			System.out.println("\n-------------------------------------------------------");
			System.out.println("               New Customer Login Account               ");
			System.out.println("-------------------------------------------------------");
			createAnAccount();
			break;
		default:
			System.out.println("Unknown error has occurred..");	
		}
	}

	private void createAnAccount() {
		logger.info("Getting information from user to create an account...");
		String firstname, lastname, ssn = null, address = null, username = null, password = null;
		AccountType accountType = null;
		int userID;
		double initialDeposit = 0;
		boolean valid = false;
		int choice;
		
		System.out.print("\nPlease enter your first name: ");
		firstname = userInput.nextLine();
		System.out.print("Please enter your last name: ");
		lastname = userInput.nextLine();
		System.out.print("Please enter your address: ");
		address = userInput.nextLine();
		valid = false;
		while (!valid) {
			System.out.print("Please enter your social security number: ");
			ssn = userInput.nextLine();
			if (Pattern.matches("[a-zA-Z]+", ssn) == false && ssn.length() == 9) {
				if (bank.ssnCheck(ssn) == true) {
					valid = true;
				} else {
					System.out.println("\nWe have a registered user with the SSN you provided...");
					System.out.println("Please use Customer Login to access your account...");
					System.out.println("If you have forgotten your username/password, talk to an employee to assist you...");
					System.out.println("To exit New Customer Account Menu, type [exit]...");
				}
			} else if (ssn.equalsIgnoreCase("exit")) {
				System.out.println("Returning to Login Selection Menu...");
				return;
			}
			else {
				System.out.println("Invalid input, your social security number should only be 9 digits...");
			}
		}
		
		valid = false;
		while (!valid) {
			System.out.println("You can type [exit] to cancel this process:");
			System.out.print("Please create a username: ");
			username = userInput.nextLine();
			if (bank.usernameCheck(username) == true) {
				if (username.length()>=5) {
					valid = true;
				} else {
					System.out.println("Username must be at least 5 characters long");
				}
				
			} else if (username.equalsIgnoreCase("exit")) {
				logger.info("New customer account cancelled...");
				System.out.println("Returning to Login Selection Menu...");
				return;
			}
			else {
				System.out.println(username + " is already taken, please use a different login...");
				System.out.println("If this is your login, please use Customer Login to access your account...");
				System.out.println("If you have forgotten your username/password, talk to an employee to assist you...");
				System.out.println("To exit New Customer Account Menu, type [exit]...");
			}
		}
		
		valid = false;
		while(!valid) {
			System.out.print("Please create a password: ");
			password = userInput.nextLine();
			final Pattern textPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%&])(?=.*\\d).+$");
			if (password.length() >= 5) {
				if (textPattern.matcher(password).matches()) {
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
		
		

		
		printNewAccountMenu();
		logger.info("Opening New Account menu...");
		logger.info("Getting user information for new account...");
		valid = false;
		while(!valid) {
			
			choice = getInput(2);
			if (choice == 1) {
				accountType = AccountType.valueOf("Checking");
				valid = true;
			} else if (choice == 2) {
				accountType = AccountType.valueOf("Savings");
				valid = true;
			} else if (choice == 0) {
				logger.info("Account not created...");
				System.out.println("Account not created");
				return;
			} else {
				System.out.println("Unknown error has occured...");
			}
		}
		valid = false;
		while (!valid) {
			while (true) {
				System.out.print("Please enter an initial deposit: $");
				try {
					initialDeposit = Double.parseDouble(userInput.nextLine());
					break;
				}
				catch (NumberFormatException e){
					System.out.println("Deposit must be a number...");
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
		
		// All values for an account have now been collected
		logger.info("Information successfully received...");
		
		// Creating new account now
		userID = bank.newCustomer(firstname, lastname, ssn, address, username, password);
		logger.info("Customer Login Account #" + userID + " successfully created...");
		System.out.println("Account Successfully Created!");		
		
		
		
		logger.info("A new " + accountType.toString() + " Account has been created...");
		bank.openAccount(userID , accountType, initialDeposit);
		System.out.println("Your Login information has been created and you have applied for an account...");
		System.out.println("Returning to the Login Menu...");
	}
	void printNewAccountMenu() {
		System.out.println("\nPlease make a selection: ");
		System.out.println("[1] Apply for a New Checking Account");
		System.out.println("[2] Apply for a New Savings Account");
		System.out.println("[0] Cancel Action");
	}
	
}	

