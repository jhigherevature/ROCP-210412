package main;

import java.util.List;

import dataaccessobject.DonorDAO;
import dataaccessobject.DonorDAOImpl;
import dataaccessobject.EmployeeDAO;
import dataaccessobject.EmployeeDAOImpl;
import model.Donor;
import model.Employee;

public class Simulator {
	

	public static void main(String[] args) {
		
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
		
		
		
//		call startMenu
		StartMenuV2 sm = new StartMenuV2();
		sm.startMenuV2();
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
