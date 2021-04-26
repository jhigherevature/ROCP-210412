package dataaccessobject;

import java.util.List;

import model.Employee;

/*
 * DAO - data access object
 * 		a design pattern which models the structure of our database
 * 		it provides implementation on classes which implement the methods defined in a DAO interface class
 * 		This Structure allows for re-usable code across different database language/types
 */
public interface EmployeeDao {
	/*
	 * The DAO methods should, as a base, provide the basic CRUD operations... 
	 * (note, if you need more complex code or interactions with you database, 
	 * those are really just higher-level or more complex uses of these basic operations)
	 */
	
	public boolean insertIntoEmployees(Employee emp);
	public Employee selectEmployee(Integer id);
	public List<Employee> selectAllEmployees();
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(Employee emp);
}
