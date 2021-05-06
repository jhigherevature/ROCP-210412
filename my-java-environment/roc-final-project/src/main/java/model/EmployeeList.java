package model;

import java.util.ArrayList;

public class EmployeeList {
	private ArrayList<Integer> empID;
	private ArrayList<String> username;
	private ArrayList<String> password;
	private ArrayList<String> title;
	
	public EmployeeList(ArrayList<Integer> empID, ArrayList<String> username, ArrayList<String> password, ArrayList<String> title) {
		this.empID = empID;
		this.username = username;
		this.password = password;
		this.title = title;
	}
	
	public ArrayList<Integer> getEmpID() {
		return empID;
	}
	public ArrayList<String> getUsername() {
		return username;
	}
	public ArrayList<String> getPassword() {
		return password;
	}
	public ArrayList<String> getTitle() {
		return title;
	}
}
