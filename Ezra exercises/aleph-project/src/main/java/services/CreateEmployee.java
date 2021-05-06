package services;

import java.util.Scanner;

import dataaccessobject.EmployeeDAOImpl;
import dataaccessobject.UserpassDAOImpl;

import model.Employee;
import model.Userpass;

public class CreateEmployee {
	public boolean createEmployee() {

//		CreateUP cup = new CreateUP();  [username, password,]

		String[] newup = create_UP();
		String username = newup[0];
		String password = newup[1];
//		get username and password and create new userpass record
		UserpassDAOImpl udao = new UserpassDAOImpl();
		udao.createUserpass(username, password, "emp");
//		get id for new userpass record
		Userpass userpass = udao.selectLoginByUserAndPass(username, password);
		Integer id_user = userpass.getId_userpass();
//		
//		see below. Collect emp  info 
		Employee newe = requestEmpInfo(id_user);
//		Insert info into emp object and create record in database
		EmployeeDAOImpl edao = new EmployeeDAOImpl();
		System.out.println(newe.toString());
		;
		if(edao.insertIntoEmployees(newe)) {return true;}
		else {return false;}

	}

	private String[] create_UP() {
		String[] NewUP = new String[2];
		System.out.println("Please choose employee username");
		Scanner scan = new Scanner(System.in);
		NewUP[0] = scan.nextLine();
		System.out.println("Username selected is: " + NewUP[0] + "\n Please choose employee password");
		// Scanner scan = new Scanner(System.in);
		NewUP[1] = scan.nextLine();
		System.out.println("Username selected is " + NewUP[0] + "\n" + "Password selected is " + NewUP[1]);
		return NewUP;
	}

	public Employee requestEmpInfo(Integer id_user) {
		Employee e = new Employee();
		System.out.println("Please input the following information to fill out employee profile:");
		System.out.println("first name");
		Scanner scan = new Scanner(System.in);
		e.setFirst_name(scan.nextLine());

		System.out.println("last name");
		e.setLast_name(scan.nextLine());

		System.out.println("Employee Title");
		e.setEmp_title(scan.nextLine());

		e.setId_userpass(id_user);

		return e;
	}

}
