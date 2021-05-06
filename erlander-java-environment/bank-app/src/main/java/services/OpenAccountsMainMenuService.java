package services;

import model.Admin;
import model.Customer;
import utilities.ScannerUtility;
import view.Printable;

public class OpenAccountsMainMenuService {
	ScannerUtility s = ScannerUtility.getInstance();
	boolean quit = false;
	int choice;
	CustomerMainMenuService cMenu = new CustomerMainMenuService();
	
	Printable accountMenu = () -> {
		System.out.println("\n1. View open accounts.");
		System.out.println("2. Make a transaction.");
		System.out.println("9. Go back");
		System.out.print("\nPlease enter your selection (1, 2, or 9 to go back): ");
	};	
	
	public void accountsMenu(Customer customer) {
		accountMenu.print();

		while (!quit) {

			ifElse: if (s.scan.hasNextInt()) {

				choice = s.scan.nextInt();
				s.scan.nextLine();

				switch (choice) {
				case 1:
					OpenAccountsService viewOpen = new OpenAccountsService();
					viewOpen.viewOpenAccounts(customer);
					break;
				case 2:
					TransactionMainMenuService transactions = new TransactionMainMenuService();
					transactions.mainMenu(customer);
					break;
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
			
		}
		
		cMenu.mainMenu(customer);
		
	}
	
	public void accountsMenu(Admin admin) {
//		accountMenu.print();
//
//		while (!quit) {
//
//			ifElse: if (s.scan.hasNextInt()) {
//
//				choice = s.scan.nextInt();
//				s.scan.nextLine();
//
//				switch (choice) {
//				case 1:
//					OpenAccountsService viewOpen = new OpenAccountsService();
//					viewOpen.viewOpenAccounts(admin);
//					break;
//				case 2:
//					TransactionMainMenuService transactions = new TransactionMainMenuService();
//					transactions.mainMenu(admin);
//					break;
//				case 9:
//					quit = true;
//					break ifElse;
//				default:
//					System.out.println("\nPlease enter a valid choice. (1, 2, 3, or 9 to go back)");
//					break;
//				}
//			} else {
//				s.scan.nextLine();
//				System.out.println("Please enter a valid choice. (1, 2, 3, or 9 to go back)");
//				continue;
//			}
//			
//		}
		
	}

}
