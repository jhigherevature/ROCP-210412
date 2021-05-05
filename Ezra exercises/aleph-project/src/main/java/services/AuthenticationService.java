package services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dataaccessobject.AccountDAOImpl;
import dataaccessobject.DonorDAO;
import dataaccessobject.DonorDAOImpl;
import dataaccessobject.EmployeeDAO;
import dataaccessobject.EmployeeDAOImpl;
import dataaccessobject.UserpassDAO;
import dataaccessobject.UserpassDAOImpl;
import main.CUR;
import model.Donor;
import model.Employee;
import model.Userpass;

public class AuthenticationService {
	public static Logger log = LogManager.getLogger(AuthenticationService.class);
	
	private static UserpassDAO udao;
	private static EmployeeDAO edao;
	private static DonorDAO ddao;
	
	public static Employee authenticateEmployee(String[] str) {
		log.info("Authentication Service called on: " + str[0] + " " + str[1]);
		udao = new UserpassDAOImpl();
		edao = new EmployeeDAOImpl();
		Userpass userpass = null; 
		Employee emp = null;
		userpass = udao.selectLoginByUserAndPass(str[0], str[1]);
		CUR.getCUR().setUserpass(userpass);
		
		if (userpass != null) {
			if (userpass.getAccess_lvl() == "donor") {
				log.warn("Login Failed!");
				System.out.println("Username and password combination were not found. Please try again.");
				CUR.getCUR().incLogincounter();
				log.warn("Employee Login failed due to login with donor credentials");
				return null;
			}
//			System.out.println("userpass is not null");
//				emp = edao.selectEmployeeByLoginId(userpass.getId_userpass());
				CUR.getCUR().setEmp(edao.selectEmployeeByLoginId(userpass.getId_userpass()));

				//			set option to default to admin token instead of emp token if userpass access_lvl = 'admin'
				CUR.getCUR().setAccess_token("emp");
				System.out.println("Login successful! Welcome "+CUR.getCUR().getEmp().getFirst_name()+" "+CUR.getCUR().getEmp().getLast_name()+". You are currently logged in as a "+ CUR.getCUR().getAccess_token()+".");
		}
		else {
//			log.warn("Login Failed!");
			System.out.println("Username and password combination were not found. Please try again.");
			CUR.getCUR().incLogincounter();
			log.warn("Employee Login failed due to incorrect username and password");
		}
		return CUR.getCUR().getEmp();
	}
	
	public static Donor authenticateDonor(String[] str) {
//		log.info("Authentication Service called on: " + str[0] + " " + str[1]);
		udao = new UserpassDAOImpl();
		ddao = new DonorDAOImpl();
		Userpass userpass = null; 
		Donor donor = null;
		userpass = udao.selectLoginByUserAndPass(str[0], str[1]);
		userpass = udao.selectLoginByUserAndPass(str[0], str[1]);
		CUR.getCUR().setUserpass(userpass);
		
		if (userpass != null){
			CUR.getCUR().setDonor(ddao.selectDonorByLoginId(userpass.getId_userpass()));
			CUR.getCUR().setAccess_token("donor");
			System.out.println("Login successful! Welcome "+CUR.getCUR().getDonor().getFirst_name()+" "+CUR.getCUR().getDonor().getLast_name()+". You are currently logged in as a "+ CUR.getCUR().getAccess_token()+".");
//			
			
//			donor = ddao.selectDonorByLoginId(userpass.getId_userpass());
//			CUR.getCUR().setAccess_token("donor");
//			System.out.println("Login successful! Welcome "+donor.getFirst_name()+" "+donor.getLast_name()+". You are currently logged in as a "+ CUR.getCUR().getAccess_token()+".");
//			create object in CUR
//			CUR.getCUR().setDonor(donor);
			AccountDAOImpl aDAO = new AccountDAOImpl();
//			System.out.println(CUR.getCUR().getDonor().toString());

//			System.out.println(CUR.getCUR().getDonor().getId_account());
			CUR.getCUR().setAcc(aDAO.selectAccount(CUR.getCUR().getDonor().getId_account()));
	}
	else {
		System.out.println("Username and password combination were not found. Please try again.");
		CUR.getCUR().incLogincounter();
//		log.warn("Login Failed!");
	}
	return CUR.getCUR().getDonor();
	}
}
