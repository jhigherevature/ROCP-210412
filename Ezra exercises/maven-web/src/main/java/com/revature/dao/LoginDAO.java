package com.revature.dao;

import com.revature.model.Login;

public interface LoginDAO {
	public Login selectLoginByUserAndPass(String user_name, String user_pass);
	
	public Boolean insertNewLogin(Login login);
}
