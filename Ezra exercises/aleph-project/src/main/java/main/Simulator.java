package main;

import java.util.List;

import dataaccessobject.DonorDAO;
import dataaccessobject.DonorDAOImpl;
import dataaccessobject.EmployeeDAO;
import dataaccessobject.EmployeeDAOImpl;
import dataaccessobject.SchoolDAOImpl;
import dataaccessobject.UserpassDAOImpl;
import model.Donor;
import model.Employee;
import model.School;
import services.AuthenticationService;

public class Simulator {
	

	public static void main(String[] args) {

		
//		System.out.println("soemhing");
//		SchoolDAOImpl sdao = new SchoolDAOImpl();
//		List<School> s = sdao.selectAllSchools();
//		System.out.println(s.toString());
//		for (School sc : s) { 
//			System.out.println("School ID: "+ sc.getId_school() +"\tSchool name: " + sc.getName_school());
//				}
//		System.out.println("List - For Loop");
//		for (List<School> s = alist.iterator(); s.hasNext(); ) {
//			String name = s.next();
//			System.out.println(name);
//		}
		
//		testing
//		String[] loginObject = null;
//		CheckLogin cl = new CheckLogin();
//		cl.checkLogin();
//		String un= (loginObject[0] + " " + loginObject[1]);
// 	 	String token = loginObject[2];
//
//System.out.println(token);
//System.out.println(un);
//		;
//		UserpassDAOImpl up = new UserpassDAOImpl();
//		System.out.println(up.selectLoginByUserAndPass("John", "b"));
//		
//		String[] str = new String[] {"John", "b"};
//		Donor donor = AuthenticationService.authenticateDonor(str);
//		System.out.println(donor);
		
//		call startMenu
		StartMenu sm = new StartMenu();
		sm.startMenu();
//		UserpassDAOImpl udao = new UserpassDAOImpl();
//
//		System.out.println(udao.selectLoginByUserAndPass("John", "b"));
//		String username = "username";
//		String password = "password";
//		String access_lvl = "donor";
//		udao.createUserpass(username, password, access_lvl);

//		udao.createUserpass(username, password, "donor");
		
		
//		StartMenuV2 sm = new StartMenuV2();
//		sm.startMenuV2();
//		
//		EmployeeDAO eDao = new EmployeeDAOImpl();
//		List<Employee> testList = eDao.selectAllEmployees();
//		System.out.println(testList);
//		
//		
//		DonorDAO dDao = new DonorDAOImpl();
//		List<Donor> testList = dDao.selectAllDonors();
//		
//		for (Donor d : testList) {
//			System.out.println(d);
//		}
//		
//		Donor d = new Donor(default, "91115", "mrs", "Johnsonetta", "Johnson", "4123 Lineway dr.", "Atlanta", "GA", 90740, "123-456-7899", "Johnsonetta@johnson.com", "642-12-1234", "asflinna osadfoaef kjaoef", true, true);
//		Donor d = new Donor("345437", "91115", "mrs", "Johnsonetta", "Johnson", "4123 Lineway dr.", "Atlanta", "GA", 90740, "123-456-7899", "Johnsonetta@johnson.com", "642-12-1234", "asflinna osadfoaef kjaoef", true, true);

		//		System.out.println(dDao.insertIntoDonors(d));
	}

}
