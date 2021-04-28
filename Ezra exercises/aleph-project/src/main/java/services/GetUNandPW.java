package services;

import java.util.Scanner;

public class GetUNandPW {

	public static String[] getUNandPW() {
		
	String[] UNandPW = new String[2];
	System.out.println("Please type in your username");
	Scanner scan = new Scanner(System.in);
	UNandPW[0] = scan.nextLine();
	System.out.println("Username selected is: " + UNandPW[0] + "\n Please type in your password");
//	Scanner scan = new Scanner(System.in);
	UNandPW[1] = scan.nextLine();
//	System.out.println("Username selected is " + UNandPW[0] + "\n"+ "Password selected is " + UNandPW[1]);
	return UNandPW;
	}
}