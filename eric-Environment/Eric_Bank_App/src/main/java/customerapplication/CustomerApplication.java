package customerapplication;

public class CustomerApplication {
	
	private Integer customer_application_id;
	private String customer_first_name;
	private String customer_last_name;
	private String customer_username;
	private String customer_password;
	
	public CustomerApplication () {}
	//WORK ON THIS
	public CustomerApplication (Integer customer_application_id, String customer_first_name, String customer_last_name, String customer_username, String customer_password) {
		
		this.customer_application_id = customer_application_id;
		this.customer_first_name = customer_first_name;
		this.customer_last_name = customer_last_name;
		this.customer_username = customer_username;
		this.customer_password = customer_password;
		
	}

	public String getCustomer_first_name() {
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public String getCustomer_username() {
		return customer_username;
	}

	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public Integer getCustomer_application_id() {
		return customer_application_id;
	}

	public void setCustomer_application_id(Integer customer_application_id) {
		this.customer_application_id = customer_application_id;
	}
	@Override
	public String toString() {
		return "CustomerApplication [customer_application_id=" + customer_application_id + ", customer_first_name="
				+ customer_first_name + ", customer_last_name=" + customer_last_name + ", customer_username="
				+ customer_username + ", customer_password=" + customer_password + "]";
	}
	
	

}
