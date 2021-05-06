package main;

import java.util.List;
import java.util.Scanner;

import dataaccessobject.PledgeDAOImpl;
import model.Pledge;
import services.CreatePledge;

public class EmpPledgeMenu {

	public void menu() {
//			choose pledge year
		System.out.println("Please choose the year you would like to examine");
		Scanner scan = new Scanner(System.in);
		CUR.getCUR().setPledgeyear(scan.nextInt());
//			show pledge summary
		PledgeDAOImpl pdao = new PledgeDAOImpl();
		System.out.println("The current total number of pledges for pledge year " + CUR.getCUR().getPledgeyear()
				+ " is: " + pdao.getPledgeNumberAll(CUR.getCUR().getPledgeyear()));
		System.out.println("The total value of all pledges for pledge year " + CUR.getCUR().getPledgeyear() + " is: $"
				+ pdao.getPledgeValueAll(CUR.getCUR().getPledgeyear()));

		String[] menuopt = new String[] { "Create pledge", "Edit a pledge *coming soon*", "Remove a pledge",
				"Return to previous menu", "Logout" };

		System.out.println("Please choose one of the following options:");
		for (int i = 1; i <= menuopt.length; i++) {
			System.out.println(i + ") " + menuopt[(i - 1)]);
		}
//			open scanner
		scan = new Scanner(System.in);
		int mchoice = scan.nextInt();
		switch (mchoice) {
		case 1:
//				create pledge
			CreatePledge cp = new CreatePledge();
			if (cp.createPledgeAdmin()) {
				System.out.println("Pledge added.");
			} else {
				System.out.println("Pledge failed. Please try again.");
			}
			System.out.println("Pledge inputed. Returning you to pledge overview...");
			menu();
			break;
		case 2:
//				edit pledge
			System.out.println("Please choose one of the following pledges to edit by pledge id number:");

			List<Pledge> pledges = pdao.selectPledgesByYear(CUR.getCUR().getPledgeyear());
			for (Pledge p : pledges) {
//				System.out.println("Pledge id: "+p.getId_pledge()+", Account id: "+p.getId_account()+", Pledge value: "+p.getPledge_amt()+", Pledge value: "+p.getId_school());
System.out.println("Pledge Id=" + p.getId_pledge() + ", Account ID=" + p.getId_account() + ", year_pledge=" + p.getYear_pledge()
				+ ", pledge_amt=" + p.getPledge_amt() + ", School ID=" + p.getId_school() + ", date_pledged=" + p.getDate_pledged()
				+ ", status_pledge=" + p.getStatus_pledge() + ", submission_date=" + p.getSubmission_date() + ", approval_date="
				+ p.getApproval_date() + "]");
			}
			Pledge edit = pdao.selectPledge(scan.nextInt());
			if (pdao.updatePledge(edit)) {
				System.out.println("Pledge updated.");
			} else {
				System.out.println("Operation failed");
			}
			menu();
			break;
		case 3:
//				delete pledge
			System.out.println("Choose pledge ID of the pledge you wish to delete");
			pledges = pdao.selectPledgesByYear(CUR.getCUR().getPledgeyear());
			for (Pledge p : pledges) {
System.out.println("Pledge [id_pledge=" + p.getId_pledge() + ", id_account=" + p.getId_account() + ", year_pledge=" + p.getYear_pledge()
				+ ", pledge_amt=" + p.getPledge_amt() + ", id_school=" + p.getId_school() + ", date_pledged=" + p.getDate_pledged()
				+ ", status_pledge=" + p.getStatus_pledge() + ", submission_date=" + p.getSubmission_date() + ", approval_date="
				+ p.getApproval_date() + "]");
			}
			Integer pledge = scan.nextInt();
			System.out.println(pdao.selectPledge(pledge));
			System.out.println("Confirm that you want to delete this pledge. (yes/no)");
			scan.nextLine();
			String yn = scan.nextLine().toLowerCase().intern();
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
//				return to previous menu
			System.out.println("Returning to Main Menu...");
			MainEmployeeMenu mem = new MainEmployeeMenu();
			mem.menu();
			break;
		case 5:
//				logout
			System.out.println("Thank you for visiting " + CUR.getCUR().getProgname() + ". See you again soon!");
			System.exit(0);

			break;
		}
	}

}
