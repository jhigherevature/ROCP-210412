package com.bankingapp.business.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.bankingapp.dataaccess.AccountDAO;

class CustomerServiceImplTest {

	@Mock
	AccountDAO accountDAO;
	
	@Test
	@DisplayName("CreateNewCustomer should return new customer")
	void createNewCustomerShouldReturnCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testFindCustomer() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllCustomers() {
		fail("Not yet implemented");
	}

	@Test
	void testFindCustomersBy() {
		fail("Not yet implemented");
	}

}
