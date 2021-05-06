package services;

import java.util.List;

import dao.AccountDAO;
import dao.CustomerAccountDAO;
import dao.CustomerDAO;
import model.Account;
import model.Customer;
import utilities.DAOUtility;
import utilities.ScannerUtility;

public class AccountApplicationService {
	ScannerUtility s = ScannerUtility.getInstance();
	AccountDAO adao = DAOUtility.getAccountDAO();
	CustomerAccountDAO cdao = DAOUtility.getCustomerAccountDAO();
	CustomerDAO customer = DAOUtility.getCustomerDAO();
	CustomerMainMenuService customerMenu = new CustomerMainMenuService();
	int accountNumber;
	boolean accountCreated = false;
	boolean quit = false;
	int choice;

	public void applyForAccount(Customer customer) {
		accountNumber = adao.createNewAccount();

		accountCreated = cdao.createCustomerAccount(customer.getCustomerID(), accountNumber);

		if (accountCreated) {
			System.out.println(
					"\nAn application for an account with account number " + accountNumber + " has been submitted!\n");

			System.out.println("Returning to customer menu...\n");
			customerMenu.mainMenu(customer);
		}
	}

	public void viewPendingAccounts(Customer customer) {
		List<Account> customerPendingAccounts = cdao.getPendingAccounts(customer.getCustomerID());

		if (customerPendingAccounts.size() < 1) {
			System.out.println("\nYou currently have no pending account applications.");
		} else {
			customerPendingAccounts.forEach(account -> System.out.println("\nAccount Number: "
					+ account.getAccountNumber() + "\nApplication Date: " + account.getApplicationDate()));
		}

		System.out.println("\nReturning to customer menu...\n");
		customerMenu.mainMenu(customer);
	}

}
