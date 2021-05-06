package com.bankingapp.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bankingapp.entities.Account;
import com.bankingapp.entities.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	
	private Logger logger = LogManager.getLogger(CustomerDAOImpl.class);
	
	private Connection connection;
	public CustomerDAOImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public void save(String userName, String password, String name, String email, String address) throws DAOException {

		try {
			
			String sql = "INSERT INTO bank_user (user_name,user_password) VALUES (?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

			preparedStatement.executeUpdate();

			logger.debug("user record created for customer");
			
			sql = "SELECT user_id FROM bank_user WHERE user_name=?";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);

			ResultSet results = preparedStatement.executeQuery();
			results.next();
			int userId = results.getInt(1);

			logger.debug("retrieved user id created for newly created customer");
			
			sql = "INSERT INTO customer (customer_name,address,email,user_id) VALUES (?,?,?,?)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, address);
			preparedStatement.setString(3, email);
			preparedStatement.setInt(4, userId);

			preparedStatement.executeUpdate();

			logger.debug("customer record created for user");

		} catch (SQLException e) {
			logger.error("failed to save customer", e);
			throw new DAOException("Failed to save customer", e);
		}
	}

	@Override
	public Customer findCustomer(String userName, String password) throws DAOException {

		Customer customer = null;
		try {
			

			String sql = "SELECT customer_id, customer_name, address, email FROM customer JOIN bank_user ON customer.user_id = bank_user.user_id WHERE bank_user.user_name = ? AND bank_user.user_password = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
    
			ResultSet results = preparedStatement.executeQuery();
			
			logger.debug("retrieve customer record query executed");
			
			if (results.next()) {
				logger.debug("customer record found based on user name and password");
				
				int customerId = results.getInt(1);
				String customer_name = results.getString(2);
				String address = results.getString(3);
				String email = results.getString(4);

				customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customer_name);
				customer.setAddress(address);
				customer.setEmail(email);
			}else {
				logger.debug("customer record not found based on user name and password");
			}
		} catch (SQLException e) {
			logger.error("failed to find customer", e);
			throw new DAOException("Failed to find customer", e);
		}

		return customer;
	}

	@Override
	public List<Customer> findAllCustomers() throws DAOException {
		List<Customer> customers = new ArrayList<Customer>();

		try {

			String sql = "SELECT customer_id, customer_name, address, email FROM customer";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet results = preparedStatement.executeQuery();

			logger.debug("retrieve all customer records query executed");
			
			while (results.next()) {
				
				int customerId = results.getInt(1);
				String customer_name = results.getString(2);
				String address = results.getString(3);
				String email = results.getString(4);

				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customer_name);
				customer.setAddress(address);
				customer.setEmail(email);

				customers.add(customer);
			}
			if(customers.size() > 0)
				logger.debug("customer records found");
			else
				logger.debug("no customer records found");
		} catch (SQLException e) {
			logger.error("failed to find customers", e);
			throw new DAOException("Failed to find customers", e);
		}

		return customers;
	}

	@Override
	public List<Customer> findCustomersBy(Account account) throws DAOException {
		List<Customer> customers = new ArrayList<Customer>();

		try {

			String sql = "SELECT c.customer_id, customer_name, address, email FROM customer AS c JOIN account_customer AS ac ON c.customer_id = ac.customer_id  JOIN account AS a ON a.account_id = ac.account_id WHERE a.account_id =?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getAccountId());
            
			ResultSet results = preparedStatement.executeQuery();
			
			logger.debug("retrieve all customer records by account query executed");
			
			while (results.next()) {
				int customerId = results.getInt(1);
				String customer_name = results.getString(2);
				String address = results.getString(3);
				String email = results.getString(4);

				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customer_name);
				customer.setAddress(address);
				customer.setEmail(email);

				customers.add(customer);
			}
			if(customers.size() > 0)
				logger.debug("customer records for account found");
			else
				logger.debug("no customer records for account found");
		} catch (SQLException e) {
			logger.error("failed to find customers", e);
			throw new DAOException("Failed to find customers", e);
		}

		return customers;
	}

}
