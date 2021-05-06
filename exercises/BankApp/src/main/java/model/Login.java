package model;

public class Login {

	private int login_id;
	private String user_name;
	private String pass_word;
	
	public Login(int login_id, String user_name, String pass_word)
	{
		this.login_id = login_id;
		this.user_name = user_name;
		this.pass_word = pass_word;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + login_id;
		result = prime * result + ((pass_word == null) ? 0 : pass_word.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
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
		if (login_id != other.login_id)
			return false;
		if (pass_word == null) {
			if (other.pass_word != null)
				return false;
		} else if (!pass_word.equals(other.pass_word))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", user_name=" + user_name + ", pass_word=" + pass_word + "]";
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
}