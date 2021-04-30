package employees;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employees implements Serializable {
	/*
	 * this information matches the employees table in the database
	 * and will be used when accessing/changing that list
	 */	
	private Integer employeesID;
	private String firstName;
	private String lastName;
	private String job;
	private Double salary;
	private String accessLevel = "employee";
	
	public Employees() {

	}

	public Employees( String firstName, String lastName, String job, Double salary ) {
		
		this.employeesID = null;
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.salary = salary;
		
	}
	
	public Employees( Integer ID, String firstName, String lastName, String job, Double salary ) {
		
		this.employeesID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.salary = salary;
		
	}

	public Integer getEmployeeID() {
		return employeesID;
	}

	public void setEmployeeID(Integer bankerID) {
		this.employeesID = bankerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setJob(String job) {
		this.job = job;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employees [employeesID=" + employeesID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", job=" + job + ", salary=" + salary + ", accessLevel=" + accessLevel + "]";
	}

	
	
}
