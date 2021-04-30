package postgredataaccessobjects;

import java.util.List;

import employeelogin.EmployeeLogin;

public interface EmployeeLoginDAO {
	
	public boolean insertIntoEmployeeLogin();
	public EmployeeLogin selectEmployeeLogin(Integer id);
	public List<EmployeeLogin> selectAllEmployeeLogin();
	public EmployeeLogin updateUsername(Integer id, EmployeeLogin el);
	public EmployeeLogin updatePassword(Integer id, EmployeeLogin el);

}
