package services;

import java.util.List;
import java.util.Scanner;

import dataaccessobject.SchoolDAOImpl;
import model.School;

public class ChooseSchool {
	public Integer chooseSchool() {

		SchoolDAOImpl sdao = new SchoolDAOImpl();
		List<School> s = sdao.selectAllSchools();
		for (School sc : s) { 
			System.out.println("School ID: "+ sc.getId_school() +"\tSchool name: " + sc.getName_school());		
			}
		System.out.println("Type in the school ID for the school to which you wish to pledge towards.");
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
		
		
//		for (int i = 1; i <= s.size(); i++) {
//		System.out.println(s.toString());
//		}
		
//		System.out.println("Please choose your user type below:");
//		for (int i = 1; i <= s.size(); i++) {
//			System.out.println(i + ") " + s.[(i - 1)]);
//		}
//		return s;

	}
}
