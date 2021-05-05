package com.bankingapp.ui;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bankingapp.business.*;
import com.bankingapp.dataaccess.AccountDAOImpl;
import com.bankingapp.dataaccess.CustomerDAOImpl;
import com.bankingapp.entities.*;

public class CustomerUI {

	private CustomerService customerService;
	private AccountService accountService;

	private Logger logger = LogManager.getLogger(CustomerUI.class);
	
	public CustomerUI(CustomerService customerService, AccountService accountService) {
		this.customerService = customerService;
		this.accountService = accountService;
	}

	public void signUp() {
		createCustomerFromPrompt();
		logIn();
	}

	private Customer createCustomerFromPrompt() {

		System.out.println("Enter name");
		String name = ScannerUtilities.getInputString();

		System.out.println("Enter username?");
		String userName = ScannerUtilities.getInputString();

		System.out.println("Enter password");
		String password = ScannerUtilities.getInputString();

		System.out.println("Enter Address");
		String address = ScannerUtilities.getInputString();

		System.out.println("Email Address");
		String email = ScannerUtilities.getInputString();

		Customer customer = null;
		try {
			customer = customerService.createNewCustomer(userName, password, userName, email, address);
			logger.debug("new customer created successfully");
		} catch (BusinessException e) {
			logger.error("failed to create new account",e);
		}

		return customer;
	}

	public void logIn() {

		System.out.println("Enter userName");
		String userName = ScannerUtilities.getInputString();

		System.out.println("Enter password");
		String password = ScannerUtilities.getInputString();

		try {

			Customer customer = customerService.findCustomer(userName, password);
			logger.debug("Log in successfully");

			if (customer != null) {
				System.out.println("Logged in successfully!");
				startCustomerActivities(customer);
			} else {
				System.out.println("Log in failed! Try again");
				logIn();
			}

		} catch (BusinessException e) {
			logger.error("failed to log in");
		}
	}

	private void startCustomerActivities(Customer customer) throws BusinessException {

		loop: while (true) {
			System.out.println("What will you like to do today, " + customer.getCustomerName());
			System.out.println("1.Open a new account");
			System.out.println("2.View exsisting account");
			System.out.println("3.View transaction");
			System.out.println("4.Transfer funds");
			System.out.println("5.Withdrawal funds");
			System.out.println("6.Cash Deposit");
			System.out.println("7.View Personal Information");
			System.out.println("8.log out");

			int userResponse = ScannerUtilities.getResponse(1, 8);

			switch (userResponse) {
			case 1:
				openNewAccount(customer);
				break;
			case 2:
				viewCustomerAccount(customer);
				break;
			case 3:
				System.out.println("View transaction");
				break;
			case 4:
				transferFunds(customer);
				break;
			case 5:
				withdrawFunds(customer);
				break;
			case 6:
				depositMoney(customer);
				break;
			case 7:
				viewInformation(customer);
				break;
			case 8:
				System.out.println("Thanks for visiting today!");
				break loop;
			}
		}
		System.out.println();
	}

	private void openNewAccount(Customer customer) throws BusinessException {

		List<AccountType> accountTypes = accountService.getAllAccountTypes();
		logger.debug("account type selected successfully");

		System.out.println("Select account type.");

		for (int i = 0; i < accountTypes.size(); i++) {
			AccountType accountType = accountTypes.get(i);
			int optionNumber = i + 1;
			System.out.println(optionNumber + ". " + accountType.getAccountTypeName());
		}

		int customerResponse = ScannerUtilities.getResponse(1, accountTypes.size());

		AccountType accountType = accountTypes.get(customerResponse - 1);
		System.out.println(accountType.getDescription());
		Customer partner = null;

		if (customerResponse == 3 || customerResponse == 4) {
			System.out.println("Is your partner here with you? Enter their details");
			partner = createCustomerFromPrompt();
		}

		double amount = ScannerUtilities.getAmountOfMoney("How much money will you deposit today?");
		accountService.createNewAccount(accountType, amount, customer, partner);

	}

	private Account getAccountForCustomerActivity(Customer customer, String prompt) throws BusinessException {

		List<Account> accountList = accountService.findAccountsOfCustomer(customer);
		logger.debug("account of customer succesfully received");
		System.out.println(prompt);

		for (int i = 0; i < accountList.size(); i++) {
			int accountOption = i + 1;
			Account account = accountList.get(i);
			System.out.println(accountOption + ". " + account.getAccountNumber());
		}
		
		int customerResponse = ScannerUtilities.getResponse(1, accountList.size());
		return accountList.get(customerResponse - 1);
	}

	private void viewCustomerAccount(Customer customer) throws BusinessException {
		Account account = getAccountForCustomerActivity(customer, "Which account would like to view?");
		logger.debug("Account balance viewed successfully");
		System.out
				.println("The balance on account " + account.getAccountNumber() + " is " + account.getAccountBalance());
	}

	private void depositMoney(Customer customer) throws BusinessException {

		Account account = getAccountForCustomerActivity(customer, "Which account would like to deposit money into?");

		double amount = ScannerUtilities.getAmountOfMoney("How much money would you like to deposit?");

		accountService.depositMoney(account, customer, amount);

		System.out.println(amount + " has successfully been credited to your account.");
		System.out.println("Your new balance is " + account.getAccountBalance());
	}

	private void withdrawFunds(Customer customer) throws BusinessException {

		Account account = getAccountForCustomerActivity(customer, "Which account would like to withdraw money from?");

		double amount = ScannerUtilities.getAmountOfMoney("How much money would you like to withdraw?");
		accountService.withdrawMoney(account, customer, amount);

		double newBalance = account.getAccountBalance() - amount;
		if (newBalance >= 0) {
			accountService.withdrawMoney(account, customer, amount);
			System.out.println(amount + " has successfully been withdrawn from your account.");
			System.out.println("Your new balance is " + newBalance);
		} else {
			System.out.println("You may not overdraw this account");
		}
	}

	private void transferFunds(Customer customer) throws BusinessException {
		Account sourceAccount = getAccountForCustomerActivity(customer,
				"Which account would like to transfer money from?");

		Account targetAccount = getAccountForCustomerActivity(customer,
				"Which account would like to transfer money to?");

		double amount = ScannerUtilities.getAmountOfMoney("How much money would you like to transfer?");

		double newSourceBalance = sourceAccount.getAccountBalance() - amount;
		if (newSourceBalance >= 0) {
			accountService.transferMoney(sourceAccount, targetAccount, customer, amount);

			System.out.println(amount + " has successfully been transferred from " + sourceAccount.getAccountNumber()
					+ " to " + targetAccount.getAccountNumber());
		} else {
			System.out.println("Insufficient funds in the source account");
		}
	}

	private void viewInformation(Customer customer) throws BusinessException {

		System.out.println("Name: " + customer.getCustomerName());
		System.out.println("Address: " + customer.getAddress());
		System.out.println("Email: " + customer.getEmail());
		System.out.println("Here are a list of your accounts");

		List<Account> accounts = accountService.findAccountsOfCustomer(customer);

		for (Account account : accounts) {
			System.out.print("Account Number: " + account.getAccountNumber());
			System.out.print(" ");
			System.out.print("Balance: " + account.getAccountBalance());
			System.out.println();
		}
	}

	private void ViewAllTransactions(Customer customer) throws BusinessException {
		List<AccountTransaction> transactions = accountService.getAllTransactionByCustomer(customer);
		for (AccountTransaction accountTransaction : transactions) {
			System.out.print("Date: ");
			System.out.print(accountTransaction.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE));
			System.out.print("Account: ");
			System.out.print(accountTransaction.getTargetAccount().getAccountNumber());
			System.out.print("Amount: ");
			System.out.print(accountTransaction.getAmount());
			System.out.println();
		}
	}

	public static void main(String[] args) throws BusinessException {
		Customer customer = new CustomerServiceImpl(new CustomerDAOImpl()).findCustomer("jclaude", "28claude");
		var ui = new CustomerUI(new CustomerServiceImpl(new CustomerDAOImpl()),
				new AccountServiceImpl(new AccountDAOImpl()));
		ui.ViewAllTransactions(customer);
		// viewInformation(customer);
		// openNewAccount(new Scanner(System.in));
	}
}
