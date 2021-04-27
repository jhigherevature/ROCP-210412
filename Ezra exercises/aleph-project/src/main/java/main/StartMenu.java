package main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import connectutil.ConnectUtil;

public class StartMenu {
	
	public void startMenu() {
	
//	Name of Program can be easily changed here
	String progName = "Donation Fund";
//	Login Types can be easily changed here by adding to LoginType array
	String [] loginType = new ArrayList[] {"New Donor", "Donor", "School Partner", "Employee"};
	
		
	String menuChoice = null;			
	startloop: while (menuChoice != 6) {
	
		
//		Check connection to server
		try (Connection conn = ConnectUtil.getConnection()) {
			System.out.println("Connection successful");
		} catch (SQLException sqlE) {
			System.out.println("Connection failed");
			sqlE.printStackTrace();
		}	
		
//		welcome message
	System.out.println("Welcome to " +progName);
	
	System.out.println("Please type in your user type");
	for ( int l : loginType) {
		System.out.println("loginType[l]");
	}
	
//	Scanner scan = new Scanner(System.in);
//	String input = scan.nextLine();
//	System.out.println("You have chosen " + input + ". Is that correct? (y/n");
//	String input = scan.nextLine();
//	implement confirmation loop here

	menuChoice = scan.nextInt();
		
	
	switch(menuChoice) {
case Donor:
//	Implement login here
	
	System.out.println("Please type in your username");
	Scanner scan = new Scanner(System.in);
	String un = scan.nextLine();
	System.out.println("Please type in your password");
	Scanner scan = new Scanner(System.in);
	String pw = scan.nextLine();
	
case Employee: 
	

	String[] loginObject = null;
	CheckLogin cl = new CheckLogin();
	cl.checkLogin();
	String un= (loginObject[0] + " " + loginObject[1]);
	 	String token = loginObject[2];
	
	

	

	

		
	
	
