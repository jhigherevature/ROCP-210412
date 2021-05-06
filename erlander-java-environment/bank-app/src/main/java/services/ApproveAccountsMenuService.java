package services;

import model.Admin;
import model.Employee;
import utilities.ScannerUtility;
import view.Printable;

public class ApproveAccountsMenuService {
	ScannerUtility s = ScannerUtility.getInstance();
	EmployeeMainMenuService employeeMenu = new EmployeeMainMenuService();
	AdminMainMenuService adminMenu = new AdminMainMenuService();
	int choice;
	boolean quit = false;

	Printable menu = () -> {
		System.out.println("\n1. View pending accounts.");
		System.out.println("2. Approve an account by account number.");
		System.out.println("3. Approve all pending accounts.");
		System.out.println("9. Go back");
		System.out.print("\nPlease enter your selection (1, 2, 3, or 9 to go back): ");
	};

	public void approvalMenu(Employee employee) {
		menu.print();

		while (!quit) {

			ifElse: if (s.scan.hasNextInt()) {

				choice = s.scan.nextInt();
				s.scan.nextLine();

				switch (choice) {
				case 1:
					ViewPendingAccountsService viewPendingAccounts = new ViewPendingAccountsService();
					viewPendingAccounts.viewPendingAccounts(employee);
					break;
				case 2:
					ApproveAccountsService approveByID = new ApproveAccountsService();
					approveByID.approveByAccountID(employee);
					break;
				case 3:
					ApproveAccountsService approveAll = new ApproveAccountsService();
					approveAll.approveAll(employee);
					break;
				case 9:
					quit = true;
					break ifElse;
				default:
					System.out.println("\nPlease enter a valid choice. (1, 2, 3, or 9 to go back)");
					break;
				}
			} else {
				System.out.println("Please enter a valid choice. (1, 2, 3, or 9 to go back)");
				continue;
			}

		}
		
		employeeMenu.menu(employee);
	}
	
	public void approvalMenu(Admin admin) {
		menu.print();

		while (!quit) {

			ifElse: if (s.scan.hasNextInt()) {

				choice = s.scan.nextInt();
				s.scan.nextLine();

				switch (choice) {
				case 1:
					ViewPendingAccountsService viewPendingAccounts = new ViewPendingAccountsService();
					viewPendingAccounts.viewPendingAccounts(admin);
					break;
				case 2:
					ApproveAccountsService approveByID = new ApproveAccountsService();
					approveByID.approveByAccountID(admin);
					break;
				case 3:
					ApproveAccountsService approveAll = new ApproveAccountsService();
					approveAll.approveAll(admin);
					break;
				case 9:
					quit = true;
					break ifElse;
				default:
					System.out.println("\nPlease enter a valid choice. (1, 2, 3, or 9 to go back)");
					break;
				}
			} else {
				System.out.println("Please enter a valid choice. (1, 2, 3, or 9 to go back)");
				continue;
			}

		}
		
		adminMenu.mainMenu(admin);
	}
}