package javadataaccessobjects;

import java.util.Scanner;

import employeelogin.EmployeeLogin;
import employees.Employees;
import postgredataaccessobjects.EmployeeLoginDAO;
import postgredataaccessobjects.EmployeeLoginDAOImplementation;
import postgredataaccessobjects.EmployeesDAO;
import postgredataaccessobjects.EmployeesDAOImplementation;

public class ReviewEmployeeInformationDAOImplementation implements ReviewEmployeeInformationDAO{
	
	Scanner input = new Scanner (System.in);
	
	String accessLevel;
	
	public ReviewEmployeeInformationDAOImplementation() {}
	
	public ReviewEmployeeInformationDAOImplementation(String accessLevel) {
		
		this.accessLevel = accessLevel;
		
	}
	
	EmployeesDAO eDao = new EmployeesDAOImplementation("banker");
	EmployeeLoginDAO elDao = new EmployeeLoginDAOImplementation("banker");
	
	public void reviewEmployeeInformation() {
		
		System.out.print("Enter the employee ID for the account you wish to use: ");
		Integer id = input.nextInt();
		input.nextLine();
		
		rei:while(true) {
		
		Employees e = eDao.selectEmployee(id);
		EmployeeLogin el = elDao.selectEmployeeLogin(id);
		System.out.println(e);
		System.out.println(el);
		
		System.out.println("1.Update employee information"
				+ "\n2.Update employee login information"
				+ "\n3.Exit");
			
		int num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: e = updateEmployeeInformation(e.getEmployeeID(), e);
		break;
			
		case 2: el = updateLoginInformation(e.getEmployeeID(), el);
		break;
		
		case 3:
		break rei;
		
		}
		
	}
		
	}
	
	public Employees updateEmployeeInformation(Integer id, Employees e) {
		
		System.out.println("1.Update first name"
				+ "\n2.Update last name"
				+ "\n3.Update job"
				+ "\n4.Update salary"
				+ "\n5.Exit");
		
		Integer num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: e = eDao.updateEmployeeFirstName(id, e);
		return e;
			
		case 2: e = eDao.updateEmployeeLastName(id, e);
		return e;
		
		case 3: e = eDao.updateEmployeeJob(id, e);
		return e;
		
		case 4: e = eDao.updateEmployeeSalary(id, e);
		return e;
		
		case 5:
		return e;
		
		}
		
		return e;
		
	}
	
	public EmployeeLogin updateLoginInformation(Integer id, EmployeeLogin el) {
		
		System.out.println("1.Update username"
				+ "\n2.Update password"
				+ "\n3.Exit");
		
		int num = input.nextInt();
		input.nextLine();
		
		switch (num) {
		
		case 1: el = elDao.updateUsername(id, el);
		return el;
			
		case 2: el = elDao.updatePassword(id, el);
		return el;
			
		case 3: 
		return el;
		
		}
		
		return el;
		
	}
	

}
