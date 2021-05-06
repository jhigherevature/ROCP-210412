package model;

public class Employee {

	private int emp_id;
	private String emp_name;
	private int login_id;
	
	public Employee(int emp_id, String emp_name, int login_id)
	{
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.login_id = login_id;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", login_id=" + login_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + emp_id;
		result = prime * result + ((emp_name == null) ? 0 : emp_name.hashCode());
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
		Employee other = (Employee) obj;
		if (emp_id != other.emp_id)
			return false;
		if (emp_name == null) {
			if (other.emp_name != null)
				return false;
		} else if (!emp_name.equals(other.emp_name))
			return false;
		if (login_id != other.login_id)
			return false;
		return true;
	}
}