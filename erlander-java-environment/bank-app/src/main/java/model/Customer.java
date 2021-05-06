package model;

public class Customer extends User{
	private Integer customerID;
	
	public Customer() {
		super();
	}
	
	public Customer(Integer userID, String firstName, String lastName, String username, String password, Integer customerID) {
		super(userID, firstName, lastName, username, password);
		this.setCustomerID(customerID);
	}
	
	public Customer(Integer userID, String firstName, String lastName, String username, String password) {
		super(userID, firstName, lastName, username, password);
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
}
