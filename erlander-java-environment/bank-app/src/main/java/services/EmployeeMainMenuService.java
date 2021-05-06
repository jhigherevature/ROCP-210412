package services;

import model.Employee;
import utilities.ScannerUtility;
import view.Printable;

public class EmployeeMainMenuService {
	ScannerUtility s = ScannerUtility.getInstance();
	LoginService login = new LoginService();
	int choice;
	boolean quit = false;

	Printable menu = () -> {
		System.out.println("\n1. Approve/deny accounts.");
		System.out.println("2. View customers.");
		System.out.println("9. Go back");
		System.out.print("\nPlease enter your selection (1, 2, 3 or 9 to go back): ");
	};

	public void menu(Employee employee) {
		System.out.println("\nHi, " + employee.getFirstName() + ". What would you like to do today?");
		menu.print();

		while (!quit) {

			ifElse: if (s.scan.hasNextInt()) {

				choice = s.scan.nextInt();
				s.scan.nextLine();

				switch (choice) {
				case 1:
					ApproveAccountsMenuService approve = new ApproveAccountsMenuService();
					approve.approvalMenu(employee);
					break;
				case 2:
					ViewCustomersService viewCustomers = new ViewCustomersService();
					viewCustomers.viewCustomers(employee);
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

			login.logIn();
		}

	}
}
