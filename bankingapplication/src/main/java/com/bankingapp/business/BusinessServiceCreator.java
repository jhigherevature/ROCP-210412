package com.bankingapp.business;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bankingapp.dataaccess.DAOCreator;

public class BusinessServiceCreator {
	private static Logger logger = LogManager.getLogger(BusinessServiceCreator.class);
	
	//factory method that creates CustomerService
	public static CustomerService getCustomerService() throws SQLException {
		logger.debug("Creating Customer Service");
		return new CustomerServiceImpl(DAOCreator.getCustomerDAO()); //DaoCreator factory to get the customerDAO and inject it into CustomerServiceImpl
	}

	public static AccountService getAccountService() throws SQLException {
		logger.debug("Creating AccountService Service");
		return new AccountServiceImpl(DAOCreator.getAccountDAO());
	}

	public static EmployeeService getEmployeeService() throws SQLException {
		logger.debug("Creating EmployeeService Service");
		return new EmployeeServiceImpl(DAOCreator.getEmployeeDAO());
	}
}
