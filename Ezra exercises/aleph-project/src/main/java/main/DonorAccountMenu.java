package main;

import java.util.List;
import java.util.Scanner;

import dataaccessobject.AccountDAOImpl;
import dataaccessobject.UserpassDAOImpl;
import model.Donor;

public class DonorAccountMenu {
	public void menu() {
		System.out.println("This account is associated with the following people: ");
		AccountDAOImpl adao = new AccountDAOImpl();
		List<Donor> users = adao.selectDonorbyAccount(CUR.getCUR().getAcc().getId_account());
		for (Donor u : users) {
			System.out.println(u.getFirst_name()+ " "+u.getLast_name());
		}
		System.out.println("Your personal information is as follows:");
		for (Donor u : users) {
			System.out.println(u.toString());
		}
		System.out.println("Your account information is as follows:");
		System.out.println(CUR.getCUR().getAcc().toString());
		
		String [] menuopt = new String[] {"Change Username and Password", "Return to previous menu", "Logout"};

		System.out.println("Please choose one of the following options:");
		for ( int i=1 ; i<=menuopt.length; i++) {
			System.out.println(i+") "+menuopt[(i-1)]);
		}
//		open scanner
		Scanner scan = new Scanner(System.in);
		int mchoice = scan.nextInt();
		switch(mchoice) {
		case 1:	
//	change username and password	
			scan = new Scanner(System.in);
			System.out.println("Choose your new username");		
			CUR.getCUR().getUserpass().setUsername(scan.nextLine());
			System.out.println("Choose your new password");
			CUR.getCUR().getUserpass().setPw(scan.nextLine());
//			Userpass userpass = new Userpass(CUR.getCUR().getUserpass().getId_userpass(), un, pw, CUR.getCUR().getAccess_token());
			UserpassDAOImpl udao = new UserpassDAOImpl();
//			CUR.getCUR().setUserpass(userpass);
			udao.updateUserpass(CUR.getCUR().getUserpass());
			DonorAccountMenu dam = new DonorAccountMenu();
			dam.menu();
			break;
		case 2:
//			return to previous menu
			System.out.println("Returning to Main Menu...");
			MainDonorMenu mdm = new MainDonorMenu();
			mdm.menu();
			break;
		case 3:
//			logout
			System.out.println("Thank you for visiting "+CUR.getCUR().getProgname()+". See you again soon!");
			System.exit(0);
	}
}

}
