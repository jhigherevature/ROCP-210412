package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dataaccessobject.AccountDAOImpl;
import model.Account;
import model.School;

public class EmpAccountMenu {

	public void menu() {
		String[] menuopt = new String[] { "Select all accounts", "Select all inactive accounts", "Select all active accounts", "Edit account", "Return to previous menu", "Logout" };
		AccountDAOImpl adao = new AccountDAOImpl();
		EmpAccountMenu eam = new EmpAccountMenu();
//		List<Account> all = new ArrayList<Account>();


		System.out.println("Account Menu - View and Modify Accounts");
		System.out.println("There are currently "+adao.getAccountActiveNumber()+" Active accounts, "+adao.getAccountInactiveNumber()+ " Inactive accounts." );
		
		System.out.println("Please choose one of the following options:");
		for (int i = 1; i <= menuopt.length; i++) {
			System.out.println(i + ") " + menuopt[(i - 1)]);
		}
//			open scanner
		Scanner scan = new Scanner(System.in);
		int mchoice = scan.nextInt();
		switch (mchoice) {
		case 1:
//		select all accounts
			List<Account> all = adao.selectAllAccounts();
			System.out.println("All accounts:");
			for (Account a : all) {
				System.out.println(a);
			}
			eam.menu();
			break;
		case 2:
//			select all inactive accounts
			all = adao.selectAllInactiveAccounts();
			System.out.println("All inactive accounts:");

			for (Account a : all) {
				System.out.println(a);
			}
				eam.menu();
				break;	
		case 3:
//			select all active accounts
			all = adao.selectAllActiveAccounts();
			System.out.println("All active accounts:");

			for (Account a : all) {
				System.out.println(a);
			}
				eam.menu();
				break;			
		case 4:
//			edit account
//			choose account to edit
			System.out.println("What is the account number of the account you wish to edit?");
			int amod = scan.nextInt();
			Account accmod = adao.selectAccount(amod);
			System.out.println(accmod);
//			new settings
			System.out.println("Set account's updated status (active/inactive).");
			String g = scan.nextLine();
			accmod.setStatus(g);
			System.out.println("Set account's updated tax filing status.");
			accmod.setTax_filing_status(scan.nextLine());
//		edit account
				adao.insertIntoAccount(accmod);
				eam.menu();
				break;	
		case 5:
//				previous menu
			MainEmployeeMenu mem = new MainEmployeeMenu();
			mem.menu();
			break;
		case 6:
			System.out.println("Logging out of " + CUR.getCUR().getProgname() + ".");
			System.exit(0);

		}

	}		
	

}
