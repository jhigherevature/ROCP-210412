package services;

import dao.CustomerDAO;
import dao.UserDAO;
import model.Customer;
import model.User;
import utilities.DAOUtility;
import utilities.ScannerUtility;
import view.Printable;

public class NewCustomerService {
	ScannerUtility s = ScannerUtility.getInstance();
	UserDAO udao = DAOUtility.getUserDAO();
	CustomerDAO cdao = DAOUtility.getCustomerDAO();
	String firstName;
	String lastName;
	String username;
	String password;
	boolean newUsername;
	boolean whitespace;
	boolean passlength;
	User user;
	Customer customer;
	CustomerMainMenuService customerMenu = new CustomerMainMenuService();

	Printable firstNameMenu = () -> System.out.print("\nPlease enter your first name: ");
	Printable lastNameMenu = () -> System.out.print("\nPlease enter your last name: ");
	Printable usernameMenu = () -> System.out.print("\nPlease choose a username: ");
	Printable passwordMenu = () -> System.out.print("\nPlease choose a password: ");

	public void newCustomer() {

		firstNameMenu.print();
		firstName = s.scan.nextLine();

		lastNameMenu.print();
		lastName = s.scan.nextLine();

		do {
			usernameMenu.print();
			username = s.scan.nextLine();

			if (username.length() < 6 || username.length() > 24) {
				System.out.println("\n username must be between 6 and 24 characters");
				newUsername = true;
				continue;
			}
			whitespace = checkForWhitespace(username);
			if (whitespace) {
				System.out.println("\nusername must not contain whitespace");
			}

			newUsername = udao.checkIfUsernameExists(username);
			
			if (newUsername) {
				System.out.println("\nThat username already exists.");
			}
		} while (newUsername || whitespace);

		do {
			passwordMenu.print();
			password = s.scan.nextLine();

			if (password.length() < 6 || password.length() > 24) {
				System.out.println("\n password must be between 6 and 24 characters");
				passlength = true;
				continue;
			}

			whitespace = checkForWhitespace(password);
			if (whitespace) {
				System.out.println("\npassword must not contain whitespace");
			}
			
		} while (whitespace || passlength);

		user = new User(firstName, lastName, username, password);
		user = udao.createNewUser(user);

		customer = cdao.addNewCustomer(user);

		customerMenu.mainMenu(customer);

	}

	private boolean checkForWhitespace(String userInput) {
		for (int i = 0; i < userInput.length(); i++) {
			if (Character.isWhitespace(userInput.charAt(i))) {
				return true;
			}
		}
		return false;

	}

}
