package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connectutil.ConnectUtil;

public class StartMenuV2 {
	
	public void startMenuV2() {
	
//	Name of Program can be easily changed here
	String progName = "Donation Fund";
//	Login Types can be easily changed here by adding to LoginType array
	String [] loginType = new String[] {"Donor", "School Partner", "Employee", "Parent"};
		

	
		
//		Check connection to server
		try (Connection conn = ConnectUtil.getConnection()) {
			System.out.println("Connection successful");
		} catch (SQLException sqlE) {
			System.out.println("Connection failed");
			sqlE.printStackTrace();
		}	
		
		String menuChoice = null;			
//		startloop: while (menuChoice.toLowerCase() != "quit") {
		
//		welcome message
	System.out.println("Welcome to " +progName);
	System.out.println("Do you already have a user account?(y/n)");
	Scanner scan = new Scanner(System.in);
	String account = scan.nextLine();
	if (account.toLowerCase() == "n") {
//		create new donor/parent account here for other accounts contact admin
	};

	
	System.out.println("Please choose your user type");
	for (int l = 0; l <= loginType.length-1;l++) {
		System.out.println(loginType[l]);
//		System.out.println(""+l+") "+loginType[l-1]);
	}
	
//	Scanner scan = new Scanner(System.in);
//	String input = scan.nextLine();
//	System.out.println("You have chosen " + input + ". Is that correct? (y/n");
//	String input = scan.nextLine();
//	implement confirmation loop here

	menuChoice = scan.nextLine();	
	CheckLogin cl = new CheckLogin();
	String[] loginObject = cl.checkLogin(menuChoice.toLowerCase());
	if (loginObject==null) {
//		repeat process
		System.out.println("it isn't actually broken");
//		break;
	}
//	else {}
	String un= (loginObject[0] + " " + loginObject[1]);
	 	String token = loginObject[2];
	 	System.out.println("Welcome "+un+".");
	 	System.out.println("You are now logged in as a "+token+ ".");
	 	
			switch(token) {
		//	donor	
		case "donor":
			{
		//	Implement login here
			break;
			}
		//	employee
		case "employee": 
		{
			break;
		}
			
		
		// school partner
		case "school":
		{
			break;

		}
			//parent
		case "parent":
		{
			break;

		}
//		quit
		case "quit":
		{System.out.println("Thanks for using our system");
		break;
			}
	}
	}
}
//}

	

