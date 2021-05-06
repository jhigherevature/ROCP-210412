package services;

import utilities.ScannerUtility;
import view.Printable;

public class LoginService {
	ScannerUtility s = ScannerUtility.getInstance();
	int choice;
	boolean quit = false;
	
	Printable menu = () -> {
		System.out.println("Welcome! Please select one of the below options:");
		System.out.println("\n1. I am an existing customer");
		System.out.println("2. I am an existing employee");
		System.out.println("3. I am a new customer that would like to open an account");
		System.out.println("9. Quit");
		System.out.print("\nPlease enter your selection (1, 2, 3, or 9 to quit): ");
	};
	
	public void logIn(){

		menu.print();

		while (!quit) {
			
			ifElse:
			if (s.scan.hasNextInt()) {

				choice = s.scan.nextInt();
				s.scan.nextLine();

				switch (choice) {
				case 1:
					CustomerLoginService cLogin = new CustomerLoginService();
					cLogin.customerLogIn();
					break;
				case 2:
					EmployeeLoginService eLogin = new EmployeeLoginService();
					eLogin.employeeLogIn();
					break;
				case 3:
					NewCustomerService nCustomer = new NewCustomerService();
					nCustomer.newCustomer();
					break;
				case 9:
					quit = true;
					break ifElse;
				default:
					System.out.println("Please enter a valid choice. (1, 2, 3, or 9 to quit)");
					break;
				}
				
			} else {
				s.scan.nextLine();
				System.out.println("Please enter a valid choice. (1, 2, 3, or 9 to quit)");
				continue;
			}
			
		}
		
		logOut();
		
	}	
	
	public void logOut() {
		System.exit(0);
	}
	
}
