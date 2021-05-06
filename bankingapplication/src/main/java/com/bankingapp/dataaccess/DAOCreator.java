package com.bankingapp.dataaccess;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DAOCreator {
	private static Logger logger = LogManager.getLogger(DAOCreator.class);
	
	private static AccountDAO accountDAO;
	private static CustomerDAO customerDAO;
	private static EmployeeDAO employeeDAO;
	
	public static AccountDAO getAccountDAO() throws SQLException {
		if(accountDAO == null) {
			logger.debug("Creating AccountDAO");
			accountDAO = new AccountDAOImpl(DatabaseConnector.getConnection());
		}
		return accountDAO;
	}
	
	public static CustomerDAO getCustomerDAO() throws SQLException {
		if(customerDAO == null) {
			logger.debug("Creating CustomerDAO");
			customerDAO = new CustomerDAOImpl(DatabaseConnector.getConnection());
		}
		return customerDAO;
	}

	public static EmployeeDAO getEmployeeDAO() throws SQLException {
		if(employeeDAO == null) {
			logger.debug("Creating EmployeeDAO");
			employeeDAO = new EmployeeDAOImpl(DatabaseConnector.getConnection());
		}
		return employeeDAO;
	}
}
