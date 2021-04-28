package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connectutil.ConnectUtil;
import model.Donor;
import model.Employee;
import services.AuthenticationService;
import services.GetUNandPW;

public class StartMenu {
	
	public void startMenu() {
	
//	Name of Program can be easily changed here
	String progName = "Donation Fund";
//	Login Types can be easily changed here by adding to LoginType array
	String [] loginType = new String[] {"Donor", "School", "Employee", "New Donor","exit"};

	//	start static singleton info holding class - this shouldn't be necessary correct?
//	CurrentUserRef CurrentUser = CurrentUserRef.getCurrentUserRef();
//	set access token 
//	String access_token = CurrentUser.setAccess_token(null);
	String access_token = null;
//  set logincounter variable
//	int logincounter = 0;
		
//		Check connection to server
		try (Connection conn = ConnectUtil.getConnection()) {
			System.out.println("Connection successful");
		} catch (SQLException sqlE) {
			System.out.println("Connection failed");
			sqlE.printStackTrace();
		}		
//		welcome message
	System.out.println("Welcome to " +progName);
	
	int menuChoiceLogin = 0;			
	loginloop: while (menuChoiceLogin != 5) {
	
	System.out.println("Please choose your user type below:");
	for ( int i=1 ; i<=loginType.length; i++) {
		System.out.println(i+") "+loginType[(i-1)]);
	}
//	open scanner
	Scanner scan = new Scanner(System.in);

//	String input = scan.nextLine();
//	System.out.println("You have chosen " + input + ". Is that correct? (y/n");
//	String input = scan.nextLine();
//	implement confirmation loop here

	menuChoiceLogin = scan.nextInt();
		
//	GetUNandPW up = new GetUNandPW();
	switch(menuChoiceLogin) {
case 1:	//donor
//	Implement login here
	
//	Donor donor = AuthenticationService.authenticateDonor(up.getUNandPW());
	Donor donor = AuthenticationService.authenticateDonor(GetUNandPW.getUNandPW());
	if (donor == null) {
		if (CurrentUserRef.getCurrentUserRef().getLogincounter() >= 3) {
			System.out.println("Too many failed attempts.");
			menuChoiceLogin = 5;
	}
		else {
			break;
		}
	}
	if (donor !=null)	{
	menuChoiceLogin = 5;
	}
	break;
case 2: // school user
	System.out.println("School logins are not currently available at this time. Please contact admin. If you did not intend to login as a school user then please login again.");
	menuChoiceLogin=5;
	break;
case 3: 	//Employee
	
	Employee emp = AuthenticationService.authenticateEmployee(GetUNandPW.getUNandPW());
//	System.out.println(emp);
	if (emp == null) {
		if (CurrentUserRef.getCurrentUserRef().getLogincounter() >= 3) {
			System.out.println("Too many failed attempts.");
			menuChoiceLogin = 5;
		}
		else {
		break;	
	}
	}
	if (emp !=null)	{
		menuChoiceLogin = 5;
	}
		break;

case 4:
	System.out.println("Please create your new account now");
	


case 5:
	menuChoiceLogin=5;
	break;
	

	}
	}
	
	}}
	

		
	
	
