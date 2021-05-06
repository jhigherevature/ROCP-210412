package dataaccessobject;

import java.util.List;

import model.Employee;

public interface EmployeeDAO {
	
	public boolean insertIntoEmployees(Employee emp);
	public Employee selectEmployee(Integer id);
	public List<Employee> selectAllEmployees();
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(Employee emp);
	
}
