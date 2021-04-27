package dataaccessobject;

import model.Login;

public interface LoginDAO {
	public Login selectLoginByUserAndPass(String user_name, String user_pass);
}
