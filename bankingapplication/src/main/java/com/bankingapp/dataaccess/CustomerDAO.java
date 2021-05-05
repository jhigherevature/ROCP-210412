package com.bankingapp.dataaccess;

import java.util.List;

import com.bankingapp.entities.Account;
import com.bankingapp.entities.Customer;

public interface CustomerDAO {

	void save(String userName, String password, String name, String email, String address)  throws DAOException;

	Customer findCustomer(String userName, String password)  throws DAOException;

	List<Customer> findAllCustomers() throws DAOException;
	
	List<Customer> findCustomersBy(Account account) throws DAOException;

}