package javadataaccessobjects;

import employeelogin.EmployeeLogin;
import employees.Employees;

public interface ReviewEmployeeInformationDAO {
	
	public void reviewEmployeeInformation();
	public Employees updateEmployeeInformation(Integer id, Employees e);
	public EmployeeLogin updateLoginInformation(Integer id, EmployeeLogin el);

}
