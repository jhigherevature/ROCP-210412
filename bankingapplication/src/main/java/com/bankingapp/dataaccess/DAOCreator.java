package com.bankingapp.dataaccess;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DAOCreator {
	private static Logger logger = LogManager.getLogger(DAOCreator.class);
	
	private static AccountDAO accountDAO;
	private static CustomerDAO customerDAO;
	private static EmployeeDAO employeeDAO;
	
	public static AccountDAO getAccountDAO() {
		if(accountDAO == null) {
			logger.debug("Creating AccountDAO");
			accountDAO = new AccountDAOImpl();
		}
		return accountDAO;
	}
	
	public static CustomerDAO getCustomerDAO() {
		if(customerDAO == null) {
			logger.debug("Creating CustomerDAO");
			customerDAO = new CustomerDAOImpl();
		}
		return customerDAO;
	}

	public static EmployeeDAO getEmployeeDAO() {
		if(employeeDAO == null) {
			logger.debug("Creating EmployeeDAO");
			employeeDAO = new EmployeeDAOImpl();
		}
		return employeeDAO;
	}
}
