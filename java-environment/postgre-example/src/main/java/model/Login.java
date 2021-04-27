package model;

public class Login {
	private Integer login_id;
	private String user_name;
	private String user_pass;

	public Login(Integer login_id, String user_name, String user_pass) {
		super();
		this.login_id = login_id;
		this.user_name = user_name;
		this.user_pass = user_pass;
	}

	public Integer getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login_id == null) ? 0 : login_id.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + ((user_pass == null) ? 0 : user_pass.hashCode());
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
		Login other = (Login) obj;
		if (login_id == null) {
			if (other.login_id != null)
				return false;
		} else if (!login_id.equals(other.login_id))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_pass == null) {
			if (other.user_pass != null)
				return false;
		} else if (!user_pass.equals(other.user_pass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", user_name=" + user_name + ", user_pass=" + user_pass + "]";
	}

}
