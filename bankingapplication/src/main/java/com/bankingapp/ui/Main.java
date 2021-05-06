package com.bankingapp.ui;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bankingapp.business.AccountService;
import com.bankingapp.business.BusinessServiceCreator;
import com.bankingapp.business.CustomerService;
import com.bankingapp.business.EmployeeService;

public class Main {

	public static void main(String[] args) throws SQLException {
		Logger logger = LogManager.getLogger(Main.class);
		logger.info("Application started");

		CustomerService customerService = BusinessServiceCreator.getCustomerService(); //factory
		AccountService accountService = BusinessServiceCreator.getAccountService();
		EmployeeService employeeService = BusinessServiceCreator.getEmployeeService();

		CustomerUI customerUI = new CustomerUI(customerService, accountService);
		EmployeeUI employeeUI = new EmployeeUI(employeeService, accountService, customerService);

		loop: while (true) {
			System.out.println("Welcome to Bank of Chevy");
			System.out.println("What can we do for you today?");

			System.out.println("1.Login as Customer");
			System.out.println("2.login as Employee");
			System.out.println("3.Sign up as a new Customer");
			System.out.println("4.Quit");

			int userResponse = ScannerUtilities.getResponse(1, 4);

			switch (userResponse) {
			case 1:
				customerUI.logIn();
				break;
			case 2:
				employeeUI.logIn();
				break;
			case 3:
				customerUI.signUp();
				break;
			case 4:
				System.out.println("Thanks for stopping by. Hope to see you soon");
				break loop;
			}
		}
	}
}
