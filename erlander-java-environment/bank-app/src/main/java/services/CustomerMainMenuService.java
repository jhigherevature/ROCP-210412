package services;

import model.Customer;
import utilities.ScannerUtility;
import view.Printable;

public class CustomerMainMenuService {
	ScannerUtility s = ScannerUtility.getInstance();
	LoginService login = new LoginService();
	int choice;
	boolean quit = false;
	
	Printable menu = () -> {
		System.out.println("\n1. Apply for an account.");
		System.out.println("2. Open accounts menu.");
		System.out.println("3. View pending accounts.");
		System.out.println("4. Add another customer to an account. (Coming soon)");
		System.out.println("9. Go back");
		System.out.print("\nPlease enter your selection (1, 2, 3, 4, 5 or 9 to go back): ");
	};
	
	public void mainMenu(Customer customer) {
		System.out.println("\nHi, " + customer.getFirstName() + ". What would you like to do today?");
		menu.print();
		
		while (!quit) {

			ifElse:
			if (s.scan.hasNextInt()) {

				choice = s.scan.nextInt();
				s.scan.nextLine();
				
				switch (choice) {
				case 1:
					AccountApplicationService apply = new AccountApplicationService();
					apply.applyForAccount(customer);
					break;
				case 2:
					OpenAccountsMainMenuService viewOpen = new OpenAccountsMainMenuService();
					viewOpen.accountsMenu(customer);
					break;
				case 3:
					AccountApplicationService viewPending = new AccountApplicationService();
					viewPending.viewPendingAccounts(customer);
					break;
				case 4:
					//add user to account
					//break;
				case 9:
					quit = true;
					break ifElse;
				default:
					System.out.println("\nPlease enter a valid choice. (1, 2, 3, or 9 to go back)");
					break;
				}
			} else {
				s.scan.nextLine();
				System.out.println("Please enter a valid choice. (1, 2, 3, or 9 to go back)");
				continue;
			}
			
			login.logIn();
		}
		
	}

}
