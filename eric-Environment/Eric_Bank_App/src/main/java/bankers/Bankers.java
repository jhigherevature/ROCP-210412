package bankers;

import java.io.Serializable;

public class Bankers implements Serializable {
	
	private Integer bankerID;
	private String firstName;
	private String lastName;
	private String job;
	private Double salary;
	private String accessLevel = "banker";
	
	public Bankers() {

	}

	public Bankers( String firstName, String lastName, String job, Double salary) {
		
		this.bankerID = null;
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.salary = salary;
		
	}
	
	public Bankers( Integer ID, String firstName, String lastName, String job, Double salary) {
		
		this.bankerID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.job = job;
		this.salary = salary;
		
	}

	public Integer getBankerID() {
		return bankerID;
	}

	public void setBankerID(Integer bankerID) {
		this.bankerID = bankerID;
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

	public String getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public String toString() {
		return "Bankers [bankerID=" + bankerID + ", firstName=" + firstName + ", lastName=" + lastName + ", job=" + job
				+ ", salary=" + salary + ", accessLevel=" + accessLevel + "]";
	}
	
	
	
}
