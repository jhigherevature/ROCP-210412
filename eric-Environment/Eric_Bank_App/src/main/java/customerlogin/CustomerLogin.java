package customerlogin;

import java.io.Serializable;

public class CustomerLogin implements Serializable{
	
	private Integer loginID;
	private String username;
	private String password;
	
	public CustomerLogin () {}
	
	public CustomerLogin(Integer loginID, String username, String password) {
		
		this.loginID = loginID;
		this.username = username;
		this.password = password;
		
	}

	public Integer getLoginID() {
		return loginID;
	}

	public void setLoginID(Integer loginID) {
		this.loginID = loginID;
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

	@Override
	public String toString() {
		return "CustomerLogin [loginID=" + loginID + ", username=" + username + ", password=" + password + "]";
	}

}
