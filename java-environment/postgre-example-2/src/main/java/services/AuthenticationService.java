package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dataaccessobject.EmployeeDAO;
import dataaccessobject.EmployeeDAOImpl;
import dataaccessobject.LoginDAO;
import dataaccessobject.LoginDAOImpl;
import model.Employee;
import model.Login;

/*
 * Service-oriented architecture (SAO) is a design pattern
 * wherein business logic, pertaining to distinct and discrete
 * actions, is provided by dedicated service members to other
 * components of an application
 * 
 * SAO applies additional layers of abstraction for business
 * activity with the goal of achieving more complex functionality
 * without adding additional complexity to existing members which
 * perform specific, basic actions.
 */
public class AuthenticationService {
	
	public static Logger log = LogManager.getLogger(AuthenticationService.class);
	
	private static LoginDAO ldao;
	private static EmployeeDAO edao;
	
	public static Employee authenticateEmployee(String user_name, String user_pass) {
		log.info("Authentication Service called on: " + user_name + " " + user_pass);
		ldao = new LoginDAOImpl();
		edao = new EmployeeDAOImpl();
		Login login = null; 
		Employee emp = null;
		
		login = ldao.selectLoginByUserAndPass(user_name, user_pass);
		
		if (login != null)
				emp = edao.selectEmployeeByLoginId(login.getLogin_id());
		else 
			log.warn("Login Failed!");
		
		return emp;
	}
}
