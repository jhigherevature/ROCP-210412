package services;

import java.util.Scanner;

public class Constraints {
	public static double positiveDouble(double x) {
		if (x >= 0) {
			return x;
		}
		else {
			System.out.println("Unable to accept negative values. Please try again.");
			Scanner scan = new Scanner(System.in);
			x = scan.nextDouble();
			positiveDouble(x);
		}
		return x;		
	}
	
	public static int menuCon(int x) {
		if (x >= 0) {
			return x;
		}
		else {
			System.out.println("Please choose a valid menu option by number");
			Scanner scan = new Scanner(System.in);
			x = scan.nextInt();
			menuCon(x);
		}
		return x;		
	}
	
	public static int donationYear(int x) {
		int year= 2021;		//change this year to update the system.
		if (x == year) {
			return x;
		}
		if (x == (year+1)) {
			return x;
		}
		else {
			System.out.println("Donations are only able to be made for the current year and the following year. Please choose either "+year+" or "+(year+1)+".");
			Scanner scan = new Scanner(System.in);
			x = scan.nextInt();
			donationYear(x);
		}
		return x;
		
	}
}
