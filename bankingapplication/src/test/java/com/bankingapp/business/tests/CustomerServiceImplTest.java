package com.bankingapp.business.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bankingapp.business.BusinessException;
import com.bankingapp.business.CustomerServiceImpl;
import com.bankingapp.dataaccess.CustomerDAO;
import com.bankingapp.dataaccess.DAOException;
import com.bankingapp.entities.Account;
import com.bankingapp.entities.Customer;

@TestInstance(Lifecycle.PER_CLASS)
class CustomerServiceImplTest {

	@Mock
	CustomerDAO customerDAO;

	@BeforeEach
	void initializeTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("CreateNewCustomer should return new customer")
	void createNewCustomerShouldReturnCustomer() throws DAOException, BusinessException {
		// Arrange
		Customer customer = new Customer();
		customer.setUserName("testuser");
		customer.setPassword("testpassword");
		when(customerDAO.findCustomer("testuser", "testpassword")).thenReturn(customer);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerDAO);

		// Act
		Customer returnedCustomer = customerServiceImpl.createNewCustomer("testuser", "testpassword", null, null, null);

		// Assert
		assertEquals(customer, returnedCustomer);
	}

	@Test
	@DisplayName("CreateNewCustomer should throw BusinessException if DAOException is thrown")
	void createNewCustomerShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(customerDAO).save("testuser", "testpassword", null, null, null);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerDAO);

		// Act

		// Assert
		assertThrows(BusinessException.class, () -> customerServiceImpl.createNewCustomer("testuser", "testpassword", null, null, null));
	}

	@Test
	@DisplayName("findCustomer should return expected customer")
	void findCustomerShouldReturnCustomer() throws DAOException, BusinessException {
		// Arrange
		Customer customer = new Customer();
		customer.setUserName("testuser");
		customer.setPassword("testpassword");
		when(customerDAO.findCustomer("testuser", "testpassword")).thenReturn(customer);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerDAO);

		// Act
		Customer returnedCustomer = customerServiceImpl.findCustomer("testuser", "testpassword");

		// Assert
		assertEquals(customer, returnedCustomer);
	}


	@Test
	@DisplayName("findCustomer should throw BusinessException if DAOException is thrown")
	void findCustomerShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(customerDAO).findCustomer("testuser", "testpassword");
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerDAO);

		// Act

		// Assert
		assertThrows(BusinessException.class, () -> customerServiceImpl.findCustomer("testuser", "testpassword"));
	}
	
	@Test
	@DisplayName("findAllCustomer should return expected customer")
	void findAllCustomersShouldReturnListOfCustomers() throws DAOException, BusinessException {
		// Arrange
		List<Customer> customers = Arrays.asList(new Customer(), new Customer());
		when(customerDAO.findAllCustomers()).thenReturn(customers);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerDAO);

		// Act
		List<Customer> returnedCustomers = customerServiceImpl.findAllCustomers();

		// Assert
		assertEquals(customers, returnedCustomers);
	}
	
	@Test
	@DisplayName("findAllCustomers should throw BusinessException if DAOException is thrown")
	void findAllCustomersShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(customerDAO).findAllCustomers();
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerDAO);

		// Act

		// Assert
		assertThrows(BusinessException.class,()-> customerServiceImpl.findAllCustomers());
	}
	

	@Test
	void givenAccountFindCustomersByAccountShouldReturnCustomers() throws DAOException, BusinessException {
		// Arrange
		Account account = new Account();
		account.setAccountNumber("testAccountNumber");
		account.setAccountBalance(10.0);

		List<Customer> customers = Arrays.asList(new Customer(), new Customer());
		when(customerDAO.findCustomersBy(account)).thenReturn(customers);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerDAO);

		// Act
		List<Customer> returnedCustomers = customerServiceImpl.findCustomersBy(account);

		// Assert
		assertEquals(customers, returnedCustomers);
	}
	
	@Test
	@DisplayName("findAllCustomersByAccount should throw BusinessException if DAOException is thrown")
	void givenAccountFindCustomersByAccountShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		Account account = new Account();
		doThrow(DAOException.class).when(customerDAO).findCustomersBy(account);
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(customerDAO);

		// Act

		// Assert
		assertThrows(BusinessException.class,()-> customerServiceImpl.findCustomersBy(account));
	}
}
