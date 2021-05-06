package services;

import model.Admin;
import utilities.ScannerUtility;
import view.Printable;

public class AdminMainMenuService {
	ScannerUtility s = ScannerUtility.getInstance();
	LoginService login = new LoginService();
	int choice;
	boolean quit = false;
	
	Printable menu = () -> {
		System.out.println("\n1. View/Approve pending accounts.");
		System.out.println("2. View open accounts.");
		System.out.println("3. Make an account transaction.");
		System.out.println("4. Add another customer to an account. (coming soon)");
		System.out.println("9. Go back");
		System.out.print("\nPlease enter your selection (1, 2, 3, 4, 5 or 9 to go back): ");
	};
	
	public void mainMenu(Admin admin) {
		System.out.println("\nHi, " + admin.getFirstName() + ". What would you like to do today?");
		menu.print();
		
		while (!quit) {

			ifElse:
			if (s.scan.hasNextInt()) {

				choice = s.scan.nextInt();
				s.scan.nextLine();
				
				switch (choice) {
				case 1:
					ApproveAccountsMenuService approve = new ApproveAccountsMenuService();
					approve.approvalMenu(admin);
					break;
				case 2:
					OpenAccountsService viewOpen = new OpenAccountsService();
					viewOpen.viewOpenAccounts(admin);
					break;
				case 3:
					TransactionMainMenuService transaction = new TransactionMainMenuService();
					transaction.mainMenu(admin);
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
			
			System.out.print("\n");
			login.logIn();
		}
		
		
	}
}
