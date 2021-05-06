package dataaccessobject;

import java.util.List;

import model.Employee;

public class DAOTest {

	public static void main(String[] args) {
		EmployeeDAO eDAO = new EmployeeDAOImpl();
		
		Employee emp = eDAO.selectEmployee(1);
		Employee insertEmp = new Employee(null, "Doug", "Janitor", 350000.00);
		
		
		
		System.out.println(emp.getEmp_id() + ", " + emp.getEmp_name() + ", " + emp.getEmp_title() + ", " + emp.getEmp_salary());
		
		System.out.println("---------------------------");
		
		System.out.println(eDAO.insertIntoEmployees(insertEmp));
		
		System.out.println("---------------------------");
		
		List<Employee> eList = eDAO.selectAllEmployees();
		for(Employee e : eList) {
			System.out.println(e.getEmp_id() + ", " + e.getEmp_name() + ", " + e.getEmp_title() + ", " + e.getEmp_salary());
		}
		
	}

}
