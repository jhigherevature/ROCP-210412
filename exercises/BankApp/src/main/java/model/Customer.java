package model;

public class Customer {

	private int cust_id;
	private String cust_name;
	private int login_id;
	
	public Customer(int cust_id, String cust_name, int login_id)
	{
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.login_id = login_id;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + ", login_id=" + login_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cust_id;
		result = prime * result + ((cust_name == null) ? 0 : cust_name.hashCode());
		result = prime * result + login_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (cust_id != other.cust_id)
			return false;
		if (cust_name == null) {
			if (other.cust_name != null)
				return false;
		} else if (!cust_name.equals(other.cust_name))
			return false;
		if (login_id != other.login_id)
			return false;
		return true;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}
}