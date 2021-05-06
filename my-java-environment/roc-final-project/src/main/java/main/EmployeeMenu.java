package main;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Customer;
import model.CustomerList;


public class EmployeeMenu extends Menu{
	Scanner userInput = new Scanner(System.in);
	model.bank bank = new model.bank();
	static Logger logger = LogManager.getLogger(CustomerMenu.class);
	boolean exit;
	
	public void runEmployeeMenu() {
		while (!exit) {
		printEmployeeMenu();
		int choice = getInput(2);
		switch(choice) {
		case 0:
			logger.info("Employee logging out...");
			System.out.println("\nLogging out...");
			exit = true;
			break;
			
		case 1:
			logger.info("Employee starting account approval process...");
			
			System.out.println("\n-------------------------------------------------------");
			System.out.println("                   Account Approval                    ");
			System.out.println("-------------------------------------------------------");
			Customer UnApprovedCustomers = bank.getAllUnApprovedAccounts();
			if (UnApprovedCustomers==null) {
				System.out.println("No accounts need to be approved");
				break;
			}
			printCustomerUnApprovedAccounts(UnApprovedCustomers);
			System.out.println("     [0] Cancel Approval");
			System.out.println("\nWhich account would you like to approve?");
			logger.info("Employee choosing which Account to approve...");
			
			int approvalChoice = getInput(UnApprovedCustomers.getAccountType().size());
			if (approvalChoice == 0) {
				logger.info("Employee cancelling approval...");
				break;
			}
			
			int accountID = UnApprovedCustomers.getAccountID().get(approvalChoice-1);
			bank.acceptApproval(accountID);
			logger.info("A Customer Account has been approved...");
			System.out.println("Account #" + accountID + " has been approved!");
			break;
		case 2:
			logger.info("Employee viewing all Account Info...");
			System.out.println("\n-------------------------------------------------------");
			System.out.println("               Customer Information Table              ");
			System.out.println("-------------------------------------------------------");
			
			CustomerList customerList = bank.getAllAccounts();
			for (int i = 0; i<customerList.getAccountID().size(); i++) {
				System.out.println("User ID #" + customerList.getuserID().get(i) + ":");
				System.out.println("     First Name: " + customerList.getFirstname().get(i));
				System.out.println("     Last Name: " + customerList.getLastname().get(i));
				System.out.println("     Username: " + customerList.getUsername().get(i));
				System.out.print("     Password: ");
				for (int j = 0; j < customerList.getPassword().get(i).length(); j++) {
					if (j == 0) {
						System.out.print(customerList.getPassword().get(i).charAt(j));
					} else {
						System.out.print("*");
					}
				}
				System.out.println("\n     Address: " + customerList.getAddress().get(i));
				System.out.print("     ssn: ***-**-");
				for (int k = 5; k < 9; k++) {
					System.out.print(customerList.getSsn().get(i).charAt(k));
				}
				System.out.println("\n     " + customerList.getAccountType().get(i) + " #"+
						+ customerList.getAccountID().get(i));
				System.out.println("     Balance:" + customerList.getBalance().get(i));
				if (customerList.getApproved().get(i) == 1) {
					System.out.println("     Approval Status: Approved");
				} else {
					System.out.println("     Approval Status: Pending");
				}
				System.out.println("~~~~~");
			}
			
			
		}
		
		}
		
	}

	void printEmployeeMenu() {
		logger.info("Opening Employee Menu...");
		System.out.println("\n-------------------------------------------------------");
		System.out.println("                   Welcome Employee!                   ");
		System.out.println("-------------------------------------------------------");
		System.out.println("\nPlease make a selection: ");
		System.out.println("[1] Approve Accounts");
		System.out.println("[2] View Customer Information");
		System.out.println("[0] Log Out");
		
	}
	
	void printCustomerUnApprovedAccounts(Customer Customer) {
		logger.info("Printing Customer accounts pending approval...");
		System.out.println("\nHere are the accounts that are pending approval:\n");
		for (int i = 0; i < Customer.getAccountType().size(); i++) {
			System.out.println("     [" + (i+1) + "] " + Customer.getAccountType().get(i) + " #" + Customer.getAccountID().get(i) + ": $" + Customer.getBalance().get(i));
		}
		
	}
}