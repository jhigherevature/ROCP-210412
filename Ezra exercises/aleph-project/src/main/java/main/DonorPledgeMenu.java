package main;

import java.util.List;
import java.util.Scanner;

import dataaccessobject.PledgeDAOImpl;
import model.Pledge;
import services.CreatePledge;

public class DonorPledgeMenu {
	public void menu() {

//		choose pledge year
		System.out.println("Please choose the year you would like to examine");
		Scanner scan = new Scanner(System.in);
		CUR.getCUR().setPledgeyear(scan.nextInt());
//		select * where pledgeyear=
//		show pledge summary
		PledgeDAOImpl pdao = new PledgeDAOImpl();
		System.out.println("Your current total number of pledges for pledge year " + CUR.getCUR().getPledgeyear() + " is: "+pdao.getPledgeNumberAll(CUR.getCUR().getPledgeyear()));
		System.out.println("The total value of your pledges for pledge year " + CUR.getCUR().getPledgeyear() + " is: $"+pdao.getPledgeValueAll(CUR.getCUR().getPledgeyear()));
		System.out.println("The list of your pledges for pledge year " + CUR.getCUR().getPledgeyear() + " are as follows:");
		List<Pledge> plist = pdao.selectPledgesByYear(CUR.getCUR().getPledgeyear(), CUR.getCUR().getAcc().getId_account());
		for (Pledge p : plist) {
			System.out.println(p.toString());
			System.out.println(p);
		}

		String[] menuopt = new String[] { "Make a pledge", "Edit a pledge", "Remove a pledge",
				"Return to previous menu", "Logout" };

		System.out.println("Please choose one of the following options:");
		for (int i = 1; i <= menuopt.length; i++) {
			System.out.println(i + ") " + menuopt[(i - 1)]);
		}
//		open scanner
		scan = new Scanner(System.in);
		int mchoice = scan.nextInt();
		switch (mchoice) {
		case 1:
//			make a pledge
			CreatePledge cp = new CreatePledge();
			if (cp.createPledge()) {
				System.out.println("Pledge successful!");
			}
			else {
				System.out.println("Pledge failed. Please try again.");	
			}
			System.out.println("Pledge inputed. Returning you to pledge overview...");
			menu();
			break;
		case 2:
//			edit pledge
			System.out.println("Please choose one of the following pledges to edit by pledge id number:");
			
			Pledge edit = pdao.selectPledgebyDonor(scan.nextInt());
			if (edit == null) { 
				System.out.println("Please choose the pledge id from one of the above choices only"); 
				menu();
			}
			if (pdao.updatePledge(edit)) {
				System.out.println("Pledge updated.");
			} else {
				System.out.println("Operation failed");
			}			menu();
			break;
		case 3:
//			delete pledge
			System.out.println("Choose pledge ID of the pledge you wish to delete");
			Integer pledge = scan.nextInt();
			System.out.println(pdao.selectPledgebyDonor(pledge));
			System.out.println("Confirm that you want to delete this pledge. (yes/no)");
			String yn = scan.nextLine().toLowerCase().intern();
			yn = scan.nextLine().toLowerCase().intern();
			if (yn == "yes") {
				if (pdao.deletePledge(pledge)) {
					System.out.println("Pledge removed");
				} else {
					System.out.println("Operation failed}");
				}
			} else {
				System.out.println("Operation canceled");
			}
			menu();
			break;
		case 4:
//			return to previous menu
			System.out.println("Returning to Main Menu...");
			MainDonorMenu mdm = new MainDonorMenu();
			mdm.menu();
			break;
		case 5:
//			logout
			System.out.println("Thank you for visiting "+CUR.getCUR().getProgname()+". See you again soon!");
			System.exit(0);

			break;
		}
	}

}
