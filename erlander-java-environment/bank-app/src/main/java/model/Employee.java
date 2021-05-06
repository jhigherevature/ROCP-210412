package model;

public class Employee extends User{
	private Integer employeeID;
	
	public Employee() {
		super();
	}
	
	public Employee(Integer userID, String firstName, String lastName, String username, String password, Integer employeeID) {
		super(userID, firstName, lastName, username, password);
		this.setEmployeeID(employeeID);
	}
	
	public Employee(Integer userID, String firstName, String lastName, String username, String password) {
		super(userID, firstName, lastName, username, password);
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
}
