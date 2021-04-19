package userinput2;

import java.util.Scanner;

public class getConversions {

	public static void main(String[] args) {
	
		
	// get user input
		Scanner scanner = new Scanner(System.in);
	// get input to convert
	// ask user what item to choose from selection
	// set up a while loop
	// set conditions in while loop
	
		
		// looping the ask for user to input directions
		while (true) {
			
			/*
			 * having trouble setting try catch statements to catch invalid inputs
			 * for int and floats
			 */
			
			
			
			
			System.out.println("Select a conversion:\r\n"
					+ "1. Feet to Inches\r\n"
					+ "2. Feet to Yards\r\n"
					+ "3. Feet to Miles\r\n"
					+ "4. Meters to Miles\r\n"
					+ "0. Quit Program");
			// putting in a value of int
			int conversionInput = 0;
			
			// setting variable conversionInput as the input of user
			conversionInput = scanner.nextInt();
			
			// if the int value of variable conversionInput = 0 then program ends
			if (conversionInput == 0) {
				System.out.println("Exit Program");
			break;
			}
			// If input is either 1 through 4 it asks a value to convert
			System.out.println("Enter Value to Convert");
			
			// setting a float variable to be able to convert larger numbers with decimals
			// set variable a as a float and made it equal to the user input
			float a = 0f;
			a = scanner.nextFloat();
			
			// User input conditions
			// convert feet to inches
			if (conversionInput == 1) {
				a = a * 12f;
				System.out.println(a + "Inches");
			// convert feet to yards
			}else if (conversionInput == 2) {
				a = a / 3f;
				System.out.println(a + "Yards");
			// convert feet to miles
			}else if (conversionInput == 3) { 
				a = a / 5280f;
				System.out.println(a + "Miles");
			//convert meters to miles
			}else if (conversionInput == 4) { 
				a = a / 1609.34f;
				System.out.println(a + "Miles");
			}
		
}
		// closed scanner
		scanner.close();
	}
}


