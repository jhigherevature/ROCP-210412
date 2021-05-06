package services;

import java.text.DecimalFormat;
import java.util.List;

import dao.AccountDAO;
import dao.CustomerAccountDAO;
import model.Account;
import model.Admin;
import model.Customer;
import utilities.DAOUtility;

public class OpenAccountsService {
	CustomerAccountDAO cdao = DAOUtility.getCustomerAccountDAO();
	AccountDAO adao = DAOUtility.getAccountDAO();
	OpenAccountsMainMenuService menu = new OpenAccountsMainMenuService();
	AdminMainMenuService adminMenu = new AdminMainMenuService();
	private static DecimalFormat df = new DecimalFormat("#.##");
	
	void viewOpenAccounts(Customer customer) {
		List<Account> accounts = cdao.getOpenAccounts(customer.getCustomerID());
		if (accounts.size() < 1) {
			System.out.println("\nThere are no open accounts at this time.");
		} else {
			accounts.forEach(account -> System.out.println("\nAccount ID: " + account.getAccountNumber()
					+ "\nAccount balance: $" + df.format(account.getBalance()) + "\n-------------------"));
		}
		
		System.out.println("\nReturning to account menu...\n");
		menu.accountsMenu(customer);
	}
	
	void viewOpenAccounts(Admin admin) {
		List<Account> accounts = adao.getAllOpenAccounts();
		if (accounts.size() < 1) {
			System.out.println("\nThere are no open accounts at this time.");
		} else {
			accounts.forEach(account -> System.out.println("\nAccount ID: " + account.getAccountNumber()
					+ "\nAccount balance: $" + df.format(account.getBalance()) + "\n-------------------"));
		}
		
		System.out.println("\nReturning to account menu...\n");
		adminMenu.mainMenu(admin);
	}
}
