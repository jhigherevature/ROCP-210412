package model;

public class Admin extends Employee{
	private int adminID;
	
	public Admin() {
		super();
	}
	
	public Admin(int userID, String firstName, String lastName, String username, String password, int employeeID, int adminID) {
		super(userID, firstName, lastName, username, password, employeeID);
		this.setAdminID(adminID);
	}
	
	public Admin(int userID, String firstName, String lastName, String username, String password, int employeeID) {
		super(userID, firstName, lastName, username, password, employeeID);
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

}
