package customers;

import java.io.Serializable;

public class Customers implements Serializable {
	
	private Integer customerID;
	private String customerFirstName;
	private String customerLastName;
	
	private String accessLevel = "customer";
	
	public Customers () {}
	
	public Customers( String customerFirstName, String customerLastName) {
		
		customerID = null;
		this.customerFirstName= customerFirstName;
		this.customerLastName = customerLastName;
		
	}
	
	public Customers (Integer customerID, String customerFirstName, String customerLastName) {
		
		this.customerID = customerID;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
	
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	@Override
	public String toString() {
		return "Customers [customerID=" + customerID + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + "]";
	}

	

	
	
}
