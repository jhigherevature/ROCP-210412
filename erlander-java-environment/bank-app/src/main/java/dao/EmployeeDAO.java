package dao;

import model.Admin;
import model.Employee;

public interface EmployeeDAO {

	Employee getEmployeeByUserID(int userID);

	Admin checkIfAdmin(Employee employee);

}
