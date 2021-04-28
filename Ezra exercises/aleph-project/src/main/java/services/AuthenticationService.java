package services;

import dataaccessobject.DonorDAO;
import dataaccessobject.DonorDAOImpl;
import dataaccessobject.EmployeeDAO;
import dataaccessobject.EmployeeDAOImpl;
import dataaccessobject.UserpassDAO;
import dataaccessobject.UserpassDAOImpl;
import main.CurrentUserRef;
import model.Donor;
import model.Employee;
import model.Userpass;

public class AuthenticationService {
//	public static Logger log = LogManager.getLogger(AuthenticationService.class);
	
	private static UserpassDAO udao;
	private static EmployeeDAO edao;
	private static DonorDAO ddao;
	
	public static Employee authenticateEmployee(String[] str) {
//		log.info("Authentication Service called on: " + str[0] + " " + str[1]);
		udao = new UserpassDAOImpl();
		edao = new EmployeeDAOImpl();
		Userpass userpass = null; 
		Employee emp = null;
		userpass = udao.selectLoginByUserAndPass(str[0], str[1]);
		
		if (userpass != null) {
			System.out.println("userpass is not null");
				emp = edao.selectEmployeeByLoginId(userpass.getId_userpass());
//			set option to default to admin token instead of emp token if userpass access_lvl = 'admin'
				CurrentUserRef.getCurrentUserRef().setAccess_token("emp");
				System.out.println("Login successful! Welcome "+emp.getFirst_name()+" "+emp.getLast_name()+". You are currently logged in as a "+ CurrentUserRef.getCurrentUserRef().getAccess_token()+".");

		}
		else {
//			log.warn("Login Failed!");
			System.out.println("Username and password combination were not found. Please try again.");
			CurrentUserRef.getCurrentUserRef().incLogincounter();
		}
		return emp;
	}
	
	public static Donor authenticateDonor(String[] str) {
//		log.info("Authentication Service called on: " + str[0] + " " + str[1]);
		udao = new UserpassDAOImpl();
		ddao = new DonorDAOImpl();
		Userpass userpass = null; 
		Donor donor = null;
		userpass = udao.selectLoginByUserAndPass(str[0], str[1]);
		
		if (userpass != null){
			donor = ddao.selectDonorByLoginId(userpass.getId_userpass());
			CurrentUserRef.getCurrentUserRef().setAccess_token("donor");
			System.out.println("Login successful! Welcome "+donor.getFirst_name()+" "+donor.getLast_name()+". You are currently logged in as a "+ CurrentUserRef.getCurrentUserRef().getAccess_token()+".");

	}
	else {
		System.out.println("Username and password combination were not found. Please try again.");
		CurrentUserRef.getCurrentUserRef().incLogincounter();
//		log.warn("Login Failed!");
	}
	return donor;
	}
}
