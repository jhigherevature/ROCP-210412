package model;

public class User {
	
	private Integer userID;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	public User() {}
	
	public User(Integer userID, String firstName, String lastName, String username, String password) {
		this.setUserID(userID);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public User(String firstName, String lastName, String username, String password) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
