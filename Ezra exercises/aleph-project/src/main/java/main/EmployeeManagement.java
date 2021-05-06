package main;

import java.util.List;
import java.util.Scanner;

import dataaccessobject.EmployeeDAOImpl;
import model.Employee;
import services.CreateEmployee;



public class EmployeeManagement {

	public void menu() {
	
		EmployeeDAOImpl edao = new EmployeeDAOImpl();
		MainEmployeeMenu mem = new MainEmployeeMenu();
		
		
//		
		String[] menuopt = new String[] { "Create employee", "Edit employee", "Remove employee",
				"Return to previous menu", "Logout" };

		System.out.println("Please choose one of the following options:");
		for (int i = 1; i <= menuopt.length; i++) {
			System.out.println(i + ") " + menuopt[(i - 1)]);
		}
//			open scanner
		Scanner scan = new Scanner(System.in);
		int mchoice = scan.nextInt();
		switch (mchoice) {
		case 1:
//				create employee
			CreateEmployee ce = new CreateEmployee();
			if (ce.createEmployee()) {
				System.out.println("Employee added.");
			} else {
				System.out.println("Operation failed. Please try again.");
			}
			System.out.println("Pledge inputed. Returning you to Employee overview...");
			menu();
			break;
		case 2:
//				edit employee
			System.out.println("Functionality coming soon. Delete and recreate employee record if changes are needed. \nReturning you to main menu...");
//			System.out.println("Please choose one of the following pledges to edit by pledge id number:");
//
//			List<Pledge> pledges = pdao.selectPledgesByYear(CUR.getCUR().getPledgeyear());
//			for (Pledge p : pledges) {
////				System.out.println("Pledge id: "+p.getId_pledge()+", Account id: "+p.getId_account()+", Pledge value: "+p.getPledge_amt()+", Pledge value: "+p.getId_school());
//System.out.println("Pledge Id=" + p.getId_pledge() + ", Account ID=" + p.getId_account() + ", year_pledge=" + p.getYear_pledge()
//				+ ", pledge_amt=" + p.getPledge_amt() + ", School ID=" + p.getId_school() + ", date_pledged=" + p.getDate_pledged()
//				+ ", status_pledge=" + p.getStatus_pledge() + ", submission_date=" + p.getSubmission_date() + ", approval_date="
//				+ p.getApproval_date() + "]");
//			}
//			Pledge edit = pdao.selectPledge(scan.nextInt());
//			if (pdao.updatePledge(edit)) {
//				System.out.println("Pledge updated.");
//			} else {
//				System.out.println("Operation failed");
//			}
			menu();
			break;
		case 3:
//				delete employee
			System.out.println("Choose Employee ID of the employee you wish to delete");
			List<Employee>employees = edao.selectAllEmployees();
			for (Employee e : employees) {System.out.println(e.toString());
			}
			Integer emp = scan.nextInt();
			System.out.println(edao.selectEmployee(emp));
			System.out.println("Confirm that you want to delete this employee. (yes/no)");
			scan.nextLine();
			String yn = scan.nextLine().toLowerCase().intern();
			if (yn == "yes") {
				if (edao.deleteEmployeebyID(emp)) {
					System.out.println("Employee removed");
				} else {
					System.out.println("Operation failed}");
				}
			} else {
				System.out.println("Operation canceled");
			}
//			if (edao.deleteEmployeebyID(emp)) {
//				System.out.println("Employee removed");
//			} else {
//				System.out.println("Operation failed}");
//			}
			menu();
			break;
		case 4:
//				return to previous menu
			System.out.println("Returning to Main Menu...");
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
