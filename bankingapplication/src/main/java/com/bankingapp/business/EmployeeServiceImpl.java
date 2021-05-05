package com.bankingapp.business;

import com.bankingapp.dataaccess.DAOException;
import com.bankingapp.dataaccess.EmployeeDAO;
import com.bankingapp.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public Employee findEmployee(String userName, String password) throws BusinessException {
		Employee employee = null;
		try {
			employee= employeeDAO.findEmployee(userName, password);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new BusinessException("Failed to retrieve employee", e);
		}
		return employee;
	}
}
