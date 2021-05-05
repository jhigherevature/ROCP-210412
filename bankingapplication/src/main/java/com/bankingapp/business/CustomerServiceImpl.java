package com.bankingapp.business;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bankingapp.dataaccess.CustomerDAO;
import com.bankingapp.dataaccess.CustomerDAOImpl;
import com.bankingapp.dataaccess.DAOException;
import com.bankingapp.entities.Account;
import com.bankingapp.entities.Customer;

public class CustomerServiceImpl implements CustomerService {

	private Logger logger = LogManager.getLogger(CustomerServiceImpl.class);
	private CustomerDAO customerDAO;

	public CustomerServiceImpl(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public Customer createNewCustomer(String userName, String password, String name, String email, String address)
			throws BusinessException {
		Customer customer = null;
		try {
			customerDAO.save(userName, password, name, email, address);
			customer = findCustomer(userName, password);
			logger.debug("Customer find successfully");
			
		} catch (DAOException e) {
			e.printStackTrace();
			logger.error("failed to create a new customer");
			throw new BusinessException("failed to create new customer", e);
		}
		return customer;
	}

	@Override
	public Customer findCustomer(String userName, String password) throws BusinessException {
		Customer customer = null;
		try {
			customer = customerDAO.findCustomer(userName, password);
			logger.debug("Customer find successfully");
			
		} catch (DAOException e) {
			e.printStackTrace();
			logger.debug("failed to find customer");
			throw new BusinessException("failed to find customer", e);
		}
		return customer;
	}

	@Override
	public List<Customer> findAllCustomers() throws BusinessException {
		List<Customer> customers = null;
		try {
			customers = customerDAO.findAllCustomers();
			logger.debug("Customer find successfully");
		} catch (DAOException e) {
			e.printStackTrace();
			logger.debug("failed to find customer");
			throw new BusinessException("failed to find customers", e);
		}
		return customers;
	}

	@Override
	public List<Customer> findCustomersBy(Account account) throws BusinessException {
		List<Customer> customers = null;
		try {
			customers = customerDAO.findCustomersBy(account);
			logger.debug("successfully find customer by account");
		} catch (DAOException e) {
			e.printStackTrace();
			logger.error("failed tofind customer by account",e);
			throw new BusinessException("failed to find customers by account", e);
		}
		return customers;
	}
}
