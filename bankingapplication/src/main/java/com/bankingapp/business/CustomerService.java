package com.bankingapp.business;

import java.util.List;

import com.bankingapp.entities.Account;
import com.bankingapp.entities.Customer;

public interface CustomerService {
	Customer createNewCustomer(String userName, String password, String name, String email, String address) throws BusinessException;
	
	Customer findCustomer(String userName, String password) throws BusinessException;
	
	List<Customer> findAllCustomers() throws BusinessException;
	
	List<Customer> findCustomersBy(Account account) throws BusinessException;
}
