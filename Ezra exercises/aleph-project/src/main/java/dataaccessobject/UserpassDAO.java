package dataaccessobject;

import model.Userpass;

public interface UserpassDAO {
	public Userpass selectLoginByUserAndPass(String user_name, String user_pass);
	public Userpass createUserpass(String user_name, String user_pass, String access_lvl);
}
