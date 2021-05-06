package main;

import java.util.Scanner;

public class MainEmployeeMenu {

	public void menu() {

		String[] menuopt = new String[] { "Account Menu", "Donor Menu", "Pledge Menu", "Logout", "Employee Management(Admin only)" };

		System.out.println("Please choose one of the following options:");
		for (int i = 1; i <= menuopt.length; i++) {
			System.out.println(i + ") " + menuopt[(i - 1)]);
		}
//			open scanner
		Scanner scan = new Scanner(System.in);
		int mchoice = scan.nextInt();
		switch (mchoice) {
		case 1:
//		account menu
			EmpAccountMenu eam = new EmpAccountMenu();
			eam.menu();
			break;	
		case 2:
//			donor menu
		EmpDonorMenu edm = new EmpDonorMenu();
		edm.menu();
		break;
		case 3:
//				pledge menu
			EmpPledgeMenu epm = new EmpPledgeMenu();
			epm.menu();
			break;
		case 4:
			System.out.println("Logging out of " + CUR.getCUR().getProgname() + ".");
			System.exit(0);

		case 5:
			System.out.println("Only administrators may use this menu");
			String token = CUR.getCUR().getEmp().getEmp_title().intern();
			if (token == "admin") {
				System.out.println("Credentials have been confirmed. \nEmployee Management Menu");
				EmployeeManagement emm = new EmployeeManagement();
				emm.menu();
			}
			else {System.out.println("You do not have permission to access this menu. If this is a mistake please contact system administrator. Returning you to Employee Menu");
			
			menu();
			}

			break;
		}

	}
}
