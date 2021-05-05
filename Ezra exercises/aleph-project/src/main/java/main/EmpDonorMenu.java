package main;

import java.util.List;
import java.util.Scanner;

import dataaccessobject.DonorDAOImpl;
import model.Account;
import model.Donor;
import services.CreateDonor;

public class EmpDonorMenu {
	public void menu() {

		String[] menuopt = new String[] { "Select all donors", "Select all inactive donors", "Select all active donors",
				"Edit donor", "Create new donor", "Delete donor", "Return to previous menu", "Logout" };
		DonorDAOImpl ddao = new DonorDAOImpl();
		EmpDonorMenu edm = new EmpDonorMenu();
		CreateDonor cd = new CreateDonor();
//		cd = null;
		List<Donor> all = null;

		System.out.println("Donor Menu - View and Modify Donor Accounts");
		System.out.println("There are currently " + ddao.getDonorActiveNumber() + " Active donor accounts, "
				+ ddao.getDonorInactiveNumber() + " Inactive donor accounts.");

		System.out.println("Please choose one of the following options:");
		for (int i = 1; i <= menuopt.length; i++) {
			System.out.println(i + ") " + menuopt[(i - 1)]);
		}
//		open scanner
		Scanner scan = new Scanner(System.in);
		int mchoice = scan.nextInt();
		switch (mchoice) {
		case 1:
//	select all accounts
			all = ddao.selectAllDonors();
			System.out.println("All donor accounts:");
			for (Donor a : all) {
				System.out.println(a);
			}
			edm.menu();
			break;
		case 2:
//		select all inactive accounts
			all = ddao.selectAllInactiveDonors();
			System.out.println("All inactive donor accounts:");
			for (Donor a : all) {
				System.out.println(a);
			}
			edm.menu();
			break;
		case 3:
//		select all active accounts
			all = ddao.selectAllActiveDonors();
			System.out.println("All active donor accounts:");
			for (Donor a : all) {
				System.out.println(a);
			}
			edm.menu();
			break;
		case 4:
//		edit donor account
//			choose account to edit
			System.out.println("What is the account number of the account you wish to edit?");
			Integer don = scan.nextInt();
			Donor dmod = ddao.selectDonor(don);
			System.out.println(dmod);
//			input new settings
			dmod = cd.requestDonorInfo(dmod.getId_userpass(), dmod.getId_account());
//			edit donor in db
			dmod.setId_donor(don);
			System.out.println(dmod);
			boolean b = ddao.updateDonor(dmod);
//			return result
			if (b == true) {
				System.out.println("Donor account updated");
			} else {
				System.out.println("Operation failed");
			}
			edm.menu();
			break;

		case 5:
//			make new full donor account	
//			cd = new CreateDonor();
			System.out.println("Starting new account creation process.\nWalk donor through following questions.");
			cd.createDonor();
//				if (b == true) {
//					System.out.println("Donor(s) are/have now been added into system");
//				} else {
//					System.out.println("Operation failed");
//				}
			System.out.println("New account creation process finished.");

			edm.menu();
			break;
		case 6:
//		make donor inactive
			System.out.println("Set donor status to inactive.");
			System.out.println("Choose donor id number to set to inactive");
			b = ddao.deleteDonor(scan.nextInt());
			if (b == true) {
				System.out.println("Donor is now inactive");
			} else {
				System.out.println("Operation failed");
			}
			edm.menu();
			break;

		case 7:
//			previous menu
			MainEmployeeMenu mem = new MainEmployeeMenu();
			mem.menu();
			break;
		case 8:
			System.out.println("Logging out of " + CUR.getCUR().getProgname() + ".");
			System.exit(0);

		}

	}
}
