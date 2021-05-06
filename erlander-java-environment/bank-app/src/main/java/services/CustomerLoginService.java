package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.CustomerDAO;
import dao.UserDAO;
import model.Customer;
import model.User;
import utilities.DAOUtility;
import utilities.ScannerUtility;
import view.Printable;

public class CustomerLoginService {

	CustomerMainMenuService mainMenu = new CustomerMainMenuService();
	LoginService login = new LoginService();
	ScannerUtility s = ScannerUtility.getInstance();
	UserDAO udao = DAOUtility.getUserDAO();
	CustomerDAO cdao = DAOUtility.getCustomerDAO();
	User user;
	String customerUsername;
	String customerPassword;
	Customer customer;
	boolean isUsername;
	boolean isPassword;
	int attempts = 0;

	private static Logger log = LogManager.getLogger(CustomerLoginService.class);

	public void customerLogIn() {

		Printable usernameMenu = () -> System.out.print("\nPlease enter your username: ");
		Printable passwordMenu = () -> System.out.print("\nPlease enter your password: ");

		System.out.print("\nWelcome back! ");

		do {
			usernameMenu.print();

			customerUsername = s.scan.nextLine().toLowerCase();
			isUsername = udao.checkIfUsernameExists(customerUsername);

			if (!isUsername) {
				attempts++;
				System.out.println("\nThat is not a vaild username. Please try again. (" + (3 - attempts)
						+ " attempts remaining)");

				log.info("invalid username attempted, with username: " + customerUsername + "\n number of attempts: "
						+ attempts);
			}

		} while (!isUsername && attempts < 3);

		if (attempts == 3) {
			System.out.println("\nMaximum attempts. Returning to main menu.\n");
			login.logIn();
		} else {
			System.out.print("\nThank you! ");
			attempts = 0;

			do {
				passwordMenu.print();

				customerPassword = s.scan.nextLine();
				isPassword = udao.checkIfPasswordIsCorrect(customerUsername, customerPassword);

				if (!isPassword) {
					attempts++;
					System.out.println(
							"\nIncorrect password. Please try again. (" + (3 - attempts) + " attempts remaining)");

					log.info("invalid password attempted, with password: " + customerPassword
							+ "\n number of attempts: " + attempts);
				}

			} while (!isPassword && attempts < 3);

			if (attempts == 3) {
				System.out.println("\nMaximum attempts. Returning to main menu.\n");
				login.logIn();
			} else {

				user = udao.selectUserByUsernameAndPassword(customerUsername, customerPassword);

				log.info("Login Service called on: " + customerUsername + " " + customerPassword);
				log.info("Login Service returned: " + user.getUserID() + " " + user.getFirstName() + " "
						+ user.getLastName() + " " + user.getUsername() + " " + user.getPassword());

				customer = cdao.getCustomerByUserID(user.getUserID());

				if (customer != null) {
					log.info("Customer retrieval called");
					log.info("Customer retrieval returned: " + customer.getUserID() + " " + customer.getFirstName()
							+ " " + customer.getLastName() + " " + customer.getUsername() + " " + customer.getPassword()
							+ " " + customer.getCustomerID());
					mainMenu.mainMenu(customer);
				} else {
					System.out.println("\nNo customers match this username and password combination. Checking Employee login...");
					EmployeeLoginService eLogin = new EmployeeLoginService();
					eLogin.employeeLogInFromCustomer(user);
				}
			}
		}

	}

	public void customerLogInFromEmployee(User userFromEmployee) {
		customer = cdao.getCustomerByUserID(userFromEmployee.getUserID());
		log.info("Customer retrieval called From employee login");
		log.info("Customer retrieval from employee login returned: " + customer.getUserID() + " " + customer.getFirstName()
				+ " " + customer.getLastName() + " " + customer.getUsername() + " " + customer.getPassword()
				+ " " + customer.getCustomerID());
		mainMenu.mainMenu(customer);
		
	}

}
