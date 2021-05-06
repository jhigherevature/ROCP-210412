package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.EmployeeDAO;
import dao.UserDAO;
import model.Admin;
import model.Employee;
import model.User;
import utilities.DAOUtility;
import utilities.ScannerUtility;
import view.Printable;

public class EmployeeLoginService {
	EmployeeMainMenuService mainMenu = new EmployeeMainMenuService();
	LoginService login = new LoginService();
	ScannerUtility s = ScannerUtility.getInstance();
	UserDAO udao = DAOUtility.getUserDAO();
	EmployeeDAO edao = DAOUtility.getEmployeeDAO();
	User user;
	String employeeUsername;
	String employeePassword;
	Employee employee;
	boolean isUsername;
	boolean isPassword;
	Admin admin;
	int attempts = 0;

	private static Logger log = LogManager.getLogger(EmployeeLoginService.class);

	public void employeeLogIn() {

		Printable usernameMenu = () -> System.out.print("\nPlease enter your username: ");
		Printable passwordMenu = () -> System.out.print("\nPlease enter your password: ");

		System.out.print("\nWelcome back! ");

		do {
			usernameMenu.print();

			employeeUsername = s.scan.nextLine().toLowerCase();
			isUsername = udao.checkIfUsernameExists(employeeUsername);

			if (!isUsername) {
				attempts++;
				System.out.println("\nThat is not a vaild username. Please try again. (" + (3 - attempts)
						+ " attempts remaining)");

				log.info("invalid username attempted, with username: " + employeeUsername + "\n number of attempts: "
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

				employeePassword = s.scan.nextLine();
				isPassword = udao.checkIfPasswordIsCorrect(employeeUsername, employeePassword);

				if (!isPassword) {
					attempts++;
					System.out.println(
							"\nIncorrect password. Please try again. (" + (3 - attempts) + " attempts remaining)");

					log.info("invalid password attempted, with password: " + employeePassword
							+ "\n number of attempts: " + attempts);
				}

			} while (!isPassword && attempts < 3);

			if (attempts == 3) {
				System.out.println("\nMaximum attempts. Returning to main menu.\n");
				login.logIn();
			} else {

				user = udao.selectUserByUsernameAndPassword(employeeUsername, employeePassword);

				log.info("Login Service called on: " + employeeUsername + " " + employeePassword);
				log.info("Login Service returned: " + user.getUserID() + " " + user.getFirstName() + " "
						+ user.getLastName() + " " + user.getUsername() + " " + user.getPassword());

				employee = edao.getEmployeeByUserID(user.getUserID());

				if (employee != null) {
					log.info("Employee retrieval called");
					log.info("Employee retrieval returned: " + employee.getUserID() + " " + employee.getFirstName()
							+ " " + employee.getLastName() + " " + employee.getUsername() + " " + employee.getPassword()
							+ " " + employee.getEmployeeID());

					admin = edao.checkIfAdmin(employee);
					if(admin != null) {
						AdminMainMenuService adminMenu = new AdminMainMenuService();
						adminMenu.mainMenu(admin);
					} else {
					mainMenu.menu(employee);
					}
				} else {
					System.out.println("\nNo employees match this username and password combination. Checking Customer login...");
					CustomerLoginService cLogin = new CustomerLoginService();
					cLogin.customerLogInFromEmployee(user);
				}

			}
		}
	}

	public void employeeLogInFromCustomer(User userFromCustomer) {
		employee = edao.getEmployeeByUserID(userFromCustomer.getUserID());
		log.info("Employee retrieval called from customer login");
		log.info("Employee retrieval from customer login returned: " + employee.getUserID() + " " + employee.getFirstName()
				+ " " + employee.getLastName() + " " + employee.getUsername() + " " + employee.getPassword()
				+ " " + employee.getEmployeeID());
		admin = edao.checkIfAdmin(employee);
		if(admin != null) {
			AdminMainMenuService adminMenu = new AdminMainMenuService();
			adminMenu.mainMenu(admin);
		} else {
		mainMenu.menu(employee);
		}
		mainMenu.menu(employee);
	}
}
