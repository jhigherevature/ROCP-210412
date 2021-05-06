package services;

import java.util.List;

import dao.CustomerDAO;
import model.Customer;
import model.Employee;
import utilities.DAOUtility;

public class ViewCustomersService {
	CustomerDAO cdao = DAOUtility.getCustomerDAO();
	EmployeeMainMenuService mainMenu = new EmployeeMainMenuService();

	public void viewCustomers(Employee employee) {

		List<Customer> customers = cdao.getAllCustomers();
		if (customers.size() < 1) {
			System.out.println("\nThere are no customers at this time.");
		} else {
			customers.forEach(customer -> System.out.println("\nUser ID: " + customer.getUserID() + "\nUser name: "
					+ customer.getFirstName() + " " + customer.getLastName() + "\nUsername: " + customer.getUsername()
					+ "\nPassword: " + customer.getPassword() + "\nCustomer_ID: " + customer.getCustomerID() + "\n-------------------"));
		}

		System.out.println("\nReturning to employee menu...\n");
		mainMenu.menu(employee);
	}
}
