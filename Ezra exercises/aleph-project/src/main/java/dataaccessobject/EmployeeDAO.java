package dataaccessobject;

import java.util.List;

import model.Employee;

/*
 * DAO stands for 'Data Access Object'.
 * 
 * DAO is a design patterns which models the structure of
 * our DB and provides implementation on classes which
 * implement the methods defined in a DAO Interface class.
 * This structure allows for re-usable code across different
 * database languages/types
 */
public interface EmployeeDAO {
	/*
	 * The DAO methods should, as a base, provide the basic
	 * CRUD operations... (note, if you need more complex code
	 * or interaction with your database, those are really just
	 * higher-level or more complex uses of these basic operations
	 */
	public boolean insertIntoEmployees(Employee emp);
	public Employee selectEmployee(Integer id);
	public List<Employee> selectAllEmployees();
	public boolean updateEmployee(Employee emp);
	public boolean deleteEmployee(Employee emp);
	public Employee selectEmployeeByLoginId(Integer id);

}
