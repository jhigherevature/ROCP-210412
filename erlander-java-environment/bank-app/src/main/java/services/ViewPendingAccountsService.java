package services;

import java.util.List;

import dao.AccountDAO;
import model.Account;
import model.Admin;
import model.Employee;
import utilities.DAOUtility;

public class ViewPendingAccountsService {
	AccountDAO adao = DAOUtility.getAccountDAO();
	ApproveAccountsMenuService menu = new ApproveAccountsMenuService();
	ApproveAccountsMenuService adminMenu = new ApproveAccountsMenuService();
	
	public void viewPendingAccounts(Employee employee) {
		List<Account> accounts = adao.getAllPendingAccounts();
		if (accounts.size() < 1) {
			System.out.println("\nThere are no pending accounts at this time.");
		} else {
			accounts.forEach(account -> System.out.println("\nAccount ID: " + account.getAccountNumber() + "\nApplication date: "
					+ account.getApplicationDate() + "\n-------------------"));
		}

		System.out.println("\nReturning to account approval menu...\n");
		menu.approvalMenu(employee);
		
	}
	
	public void viewPendingAccounts(Admin admin) {
		List<Account> accounts = adao.getAllPendingAccounts();
		if (accounts.size() < 1) {
			System.out.println("\nThere are no pending accounts at this time.");
		} else {
			accounts.forEach(account -> System.out.println("\nAccount ID: " + account.getAccountNumber() + "\nApplication date: "
					+ account.getApplicationDate() + "\n-------------------"));
		}

		System.out.println("\nReturning to account approval menu...\n");
		adminMenu.approvalMenu(admin);
		
	}

}
