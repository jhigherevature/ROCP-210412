package model;

public class Userpass {
	private Integer id_userpass;
	private String username;
	private String pw;
	private String access_lvl;

	public Userpass(Integer id_userpass, String username, String pw, String access_lvl) {
		super();
		this.id_userpass = id_userpass;
		this.username = username;
		this.pw = pw;
		this.access_lvl = access_lvl;
	}

	/**
	 * @return the id_userpass
	 */
	public Integer getId_userpass() {
		return id_userpass;
	}

	/**
	 * @param id_userpass the id_userpass to set
	 */
	public void setId_userpass(Integer id_userpass) {
		this.id_userpass = id_userpass;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the pw
	 */
	public String getPw() {
		return pw;
	}

	/**
	 * @param pw the pw to set
	 */
	public void setPw(String pw) {
		this.pw = pw;
	}

	/**
	 * @return the access_lvl
	 */
	public String getAccess_lvl() {
		return access_lvl;
	}

	/**
	 * @param access_lvl the access_lvl to set
	 */
	public void setAccess_lvl(String access_lvl) {
		this.access_lvl = access_lvl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((access_lvl == null) ? 0 : access_lvl.hashCode());
		result = prime * result + ((id_userpass == null) ? 0 : id_userpass.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Userpass other = (Userpass) obj;
		if (access_lvl == null) {
			if (other.access_lvl != null)
				return false;
		} else if (!access_lvl.equals(other.access_lvl))
			return false;
		if (id_userpass == null) {
			if (other.id_userpass != null)
				return false;
		} else if (!id_userpass.equals(other.id_userpass))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Userpass [id_userpass=" + id_userpass + ", username=" + username + ", pw=" + pw + ", access_lvl="
				+ access_lvl + "]";
	}

	
}
