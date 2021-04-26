package main;

import java.util.List;

import dataaccessobject.EmployeeDAOImpl;
import dataaccessobject.EmployeeDao;
import model.Employee;

public class Simulator {
	public static void main(String[] args) {
		EmployeeDao eDAO = new EmployeeDAOImpl();
		List<Employee> testList = eDAO.selectAllEmployees();
		
		for (Employee e : testList) {
			System.out.println(e);
		}
		
//		Employee emp = new Employee(null,"From Java", "Developer", 9999.99);
//		System.out.println(eDAO.insertIntoEmployees(emp));
		
		
	}
}
