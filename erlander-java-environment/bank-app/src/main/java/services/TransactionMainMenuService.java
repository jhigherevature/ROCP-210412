package services;

import model.Admin;
import model.Customer;
import utilities.ScannerUtility;
import view.Printable;

public class TransactionMainMenuService {
	ScannerUtility s = ScannerUtility.getInstance();
	CustomerMainMenuService customerMenu = new CustomerMainMenuService();
	AdminMainMenuService adminMenu = new AdminMainMenuService();
	
	int choice;
	boolean quit = false;
	
	Printable menu = () -> {
		System.out.println("\n1. Make a deposit.");
		System.out.println("2. Make a withdrawal.");
		System.out.println("3. View past transactions.");
		System.out.println("9. Go back");
		System.out.print("\nPlease enter your selection (1, 2, 3, or 9 to go back): ");
	};
	
	public void mainMenu(Customer customer) {
		menu.print();
		
		while (!quit) {

			ifElse: if (s.scan.hasNextInt()) {

				choice = s.scan.nextInt();
				s.scan.nextLine();

				switch (choice) {
				case 1:
					TransactionsService deposit = new TransactionsService();
					deposit.makeDeposit(customer);
					break;
				case 2:
					TransactionsService withdrawal = new TransactionsService();
					withdrawal.makeWithdrawal(customer);
					break;
				case 3:
					TransactionsService transactions = new TransactionsService();
					transactions.showAllTransactions(customer);
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
		
		customerMenu.mainMenu(customer);
		
	}
	
	public void mainMenu(Admin admin) {
		menu.print();
		
		while (!quit) {

			ifElse: if (s.scan.hasNextInt()) {

				choice = s.scan.nextInt();
				s.scan.nextLine();

				switch (choice) {
				case 1:
					TransactionsService deposit = new TransactionsService();
					deposit.makeDeposit(admin);
					break;
				case 2:
					TransactionsService withdrawal = new TransactionsService();
					withdrawal.makeWithdrawal(admin);
					break;
				case 3:
					TransactionsService transactions = new TransactionsService();
					transactions.showAllTransactions(admin);
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
		
		adminMenu.mainMenu(admin);
		
	}
	
}
