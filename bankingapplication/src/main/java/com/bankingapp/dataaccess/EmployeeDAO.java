package com.bankingapp.dataaccess;

import com.bankingapp.entities.Employee;

public interface EmployeeDAO {
	Employee findEmployee(String userName, String password) throws DAOException;
}
