package com.bankingapp.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bankingapp.entities.Customer;
import com.bankingapp.entities.Employee;
import com.bankingapp.entities.EmployeeRole;

public class EmployeeDAOImpl implements EmployeeDAO{

	private Logger logger = LogManager.getLogger(EmployeeDAOImpl.class);
	@Override
	public Employee findEmployee(String userName, String password)  throws DAOException{
		Employee employee = null;
		try {
			Connection connection = DatabaseConnector.getConnection();

			String sql = "SELECT employee_name, r.role_id, r.role_name FROM employee AS e JOIN bank_user AS u ON e.user_id = u.user_id JOIN employee_role AS r ON r.role_id = e.role_id WHERE u.user_name =? AND u.user_password =?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);

			ResultSet results = preparedStatement.executeQuery();
			
			logger.debug("Customer find successfully");

			if (results.next()) {
				EmployeeRole employeeRole = new EmployeeRole();
				employeeRole.setRoleId(results.getInt(2));
				employeeRole.setRoleName(results.getString(3));
				
				employee = new Employee();
				employee.setEmployeeName(results.getString(1));
				employee.setEmployeeRole(employeeRole);
			}
		} catch (SQLException e) {
			logger.error("Failed to find customer",e);
			throw new DAOException("Failed to find customer", e);
		}

		return employee;
	}

	
}
