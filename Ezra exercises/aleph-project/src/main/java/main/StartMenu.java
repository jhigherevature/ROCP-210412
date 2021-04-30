package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import connectutil.ConnectUtil;
import logging.LoggingSimulator;
import model.Donor;
import model.Employee;
import services.AuthenticationService;
import services.CreateDonor;
import services.GetUNandPW;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; 

public class StartMenu {

	private static Logger log = LogManager.getLogger(LoggingSimulator.class);

	@SuppressWarnings({ "resource", "unused" })
	public void startMenu() {
	
//	Name of Program can be easily changed here
	String progName = "The Donation Fund";
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
		Donor donor = AuthenticationService.authenticateDonor(GetUNandPW.getUNandPW());
	if (donor == null) {
		if (CurrentUserRef.getCurrentUserRef().getLogincounter() >= 3) {
			System.out.println("Too many failed attempts.");
			log.warn("user attempted too many failed donor logins");

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
	System.out.println("School logins are not currently available at this time. Please contact admin. \nIf you did not intend to login as a school user then please login again.");
	System.exit(0);
	menuChoiceLogin=5;
	break;
case 3: 	//Employee
	
	Employee emp = AuthenticationService.authenticateEmployee(GetUNandPW.getUNandPW());
//	System.out.println(emp);
	if (emp == null) {
		if (CurrentUserRef.getCurrentUserRef().getLogincounter() >= 3) {
			System.out.println("Too many failed attempts.");
			log.warn("user attempted too many failed employee logins");
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
	CreateDonor cd = new CreateDonor();
	System.out.println("Please create your new account now");
	cd.createDonor();
	CurrentUserRef.getCurrentUserRef().setAccess_token("donor");
	break;
case 5:
	menuChoiceLogin=5;
	System.out.println("Thank you for visiting "+progName+". See you again soon!");
	System.exit(0);
	break;
	}
	}
//	Choose context menu by access_token
	
	switch(access_token = CurrentUserRef.getCurrentUserRef().getAccess_token()) {

	case "donor":
		log.info(access_token+" user successfully logged into donor menu");
		System.out.println("donor menu");
		break;
			
	case "emp":
		log.info(access_token+" user successfully logged into employee menu");
		System.out.println("employee menu");
		break;
	case "admin":
		log.info(access_token+" user successfully logged into admin menu");
		System.out.println("admin menu");
		break;	
	}

	}
}
	

		
	
	
