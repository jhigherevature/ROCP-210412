package com.bankingapp.business.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bankingapp.business.BusinessException;
import com.bankingapp.business.EmployeeServiceImpl;
import com.bankingapp.dataaccess.DAOException;
import com.bankingapp.dataaccess.EmployeeDAO;
import com.bankingapp.entities.Employee;

class EmployeeServiceImplTest {


	@Mock
	EmployeeDAO employeeDAO;

	@BeforeEach
	void initializeTest() throws DAOException {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("findEmployee should return expected customer")
	void findEmployeeShouldReturnCustomer() throws DAOException, BusinessException {
		// Arrange
		Employee employee = new Employee();
		employee.setUserName("testuser");
		employee.setPassword("testpassword");
		when(employeeDAO.findEmployee("testuser", "testpassword")).thenReturn(employee);
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl(employeeDAO);

		// Act
		Employee returnedEmployee = employeeServiceImpl.findEmployee("testuser", "testpassword");

		// Assert
		assertEquals(employee, returnedEmployee);
	}


	@Test
	@DisplayName("findCustomer should throw BusinessException if DAOException is thrown")
	void findCustomerShouldThrowBusinessException() throws DAOException, BusinessException {
		// Arrange
		doThrow(DAOException.class).when(employeeDAO).findEmployee("testuser", "testpassword");
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl(employeeDAO);

		// Act

		// Assert
		assertThrows(BusinessException.class, () -> employeeServiceImpl.findEmployee("testuser", "testpassword"));
	}
}
