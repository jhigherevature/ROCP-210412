package postgredataaccessobjects;

import java.util.List;

import employees.Employees;

public interface EmployeesDAO {
	
	//to manipulate employee data
		public boolean insertIntoEmployees();
		public Employees selectEmployee(Integer id);
		public List<Employees> selectAllEmployees();
		public Employees updateEmployeeFirstName(Integer id, Employees e);
		public Employees updateEmployeeLastName(Integer id, Employees e);
		public Employees updateEmployeeJob(Integer id, Employees e);
		public Employees updateEmployeeSalary(Integer id, Employees e);
		public boolean deleteEmployee();

}
