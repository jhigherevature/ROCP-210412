package main;

import java.sql.Date;
import java.util.List;

import dataaccessobject.EmployeeDAO;
import dataaccessobject.EmployeeDAOImpl;
import model.Employee;
import services.AuthenticationService;

public class Simulator {

	public static void main(String[] args) {
		Employee emp = AuthenticationService.authenticateEmployee("emplogin", "emppass");
		System.out.println(emp);
		
//		EmployeeDAO eDao = new EmployeeDAOImpl();
//		List<Employee> testList = eDao.selectAllEmployees();
//
//		for (Employee e : testList) {
//			System.out.println(e);
//		}
		
//		Employee emp = new Employee(null, "From Java", "Developer", 99999.99);
//		System.out.println(eDao.insertIntoEmployees(emp));
		
	}
}
