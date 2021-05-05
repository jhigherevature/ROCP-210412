package main;

import java.util.Scanner;

public class MainDonorMenu {
	public void menu() {

		String [] menuopt = new String[] {"Account Menu", "Pledge Menu","Logout"};

		System.out.println("Please choose one of the following options:");
		for ( int i=1 ; i<=menuopt.length; i++) {
			System.out.println(i+") "+menuopt[(i-1)]);
		}
//		open scanner
		Scanner scan = new Scanner(System.in);
		int mchoice = scan.nextInt();
		switch(mchoice) {
		case 1:	
//	account menu
			DonorAccountMenu dam = new DonorAccountMenu();
			dam.menu();
			break;
		case 2:
//			pledge menu
			DonorPledgeMenu dpm = new DonorPledgeMenu();
			dpm.menu();
			break;
		case 3:
			System.out.println("Thank you for visiting "+CUR.getCUR().getProgname()+". See you again soon!");
			System.exit(0);
	
		}

	}
}