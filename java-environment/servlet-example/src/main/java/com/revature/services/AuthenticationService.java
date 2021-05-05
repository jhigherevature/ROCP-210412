package com.revature.services;

import com.revature.connectionutil.ConnectionUtility;
import com.revature.dao.EmployeeDAO;
import com.revature.dao.LoginDAO;
import com.revature.model.Employee;
import com.revature.model.Login;

public class AuthenticationService {	
	private LoginDAO ldao;
	private EmployeeDAO edao;
	
	private Login login = null;
	private Employee emp = null;
	
	private static AuthenticationService auth = new AuthenticationService();
	
	public static AuthenticationService getAuthenticationSingleton() {
		if (auth.ldao == null || auth.edao == null)
			auth.init();
		
		return auth;
	}
	
	public void init() {
		auth.ldao = ConnectionUtility.getLoginDAO();
		auth.edao = ConnectionUtility.getEmployeeDAO();
	}
	
	public Employee authenticateEmployee(String user_name, String user_pass) {
		/*
		 *  we reset the Employee to null each time this method is 
		 *  called because our Authentication Service is a singleton
		 *  and we do not want the previous login attempts to stay
		 *  'recorded' when someone new tries to login...
		 *  
		 *  A better process here would be to add a 'logout' method
		 *  which resets the reference to null, and can be called 
		 *  via a button on our webpage
		 */
		emp = null; 
		login = ldao.selectLoginByUserAndPass(user_name, user_pass);
		
		if (login != null)
				emp = edao.selectEmployeeByLoginId(login.getLogin_id());
		
		return emp;
	}
}
