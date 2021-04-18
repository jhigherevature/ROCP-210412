package gathering_user_input;

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		
		convertMeasurement();
		
}
	
	public static void convertMeasurement() {
		
		Scanner scan = new Scanner(System.in);
		
		program:while(true) {
		
		System.out.println("Please select a method of measurement conversion by selecting the appropriate number:\n1. Feet to inches\n2. Feet to Yards\n3. Feet to Miles\n4. Meters to Miles\n5. Exit");
		
		int choice = scan.nextInt();
		
		switch (choice) {
		
		case 1:{
			System.out.print("Enter how many feet you want converted to inches: ");
			int feet = scan.nextInt();
			int inch = feet * 12;
			System.out.println(feet + " " + "feet is " + inch + " inches");
			break;
		}
		
		case 2:{
			System.out.print("Enter how many feet you want converted to yards: ");
			int feet = scan.nextInt();
			double yard = feet * 0.333;
			System.out.println(feet + " " + "feet is " + yard + " yards");
			break;
		}
		
		case 3:{
			System.out.print("Enter how many feet you want converted to miles: ");
			int feet = scan.nextInt();
			double mile = feet * 0.0001;
			System.out.println(feet + " " + "feet is " + mile + " miles");
			break;
		}
		
		case 4:{
			System.out.print("Enter how many meters you want converted to miles: ");
			int meter = scan.nextInt();
			double mile = meter * 0.0006;
			System.out.println(meter + " " + "meters is " + mile + " miles");
			break;
		}
		
		case 5:{
			System.out.println("Goodbye");
			scan.close();
			break program;
		}
		
	}
		
	}
		
	}
	
}
