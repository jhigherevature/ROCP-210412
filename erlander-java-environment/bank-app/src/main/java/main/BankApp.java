package main;

import services.LoginService;

public class BankApp {

	public static void main(String[] args) {
		
		LoginService logIn = new LoginService();
		
		logIn.logIn();
		
	}
}
