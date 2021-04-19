package excercises;

import java.util.Scanner;
import java.io.*;

public class ConverterProgram {

	public static void main(String...args) {
	
		String valCon = "Enter a value to convert: ";
		int cont = 0;

		do {
			if (cont == 0) {
		System.out.println("Select a conversion:\n 1. Feet to Inches\n 2. Feet to Yards\n 3. Feet to Miles\n 4. Meters to Miles");
			}
			if (cont != 0) {
				System.out.println("Select a conversion:\n 1. Feet to Inches\n 2. Feet to Yards\n 3. Feet to Miles\n 4. Meters to Miles \n 5. Quit");
					} 
		
			
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
	
	
	if (input == 1) { 
		System.out.println(valCon);
		int info = scan.nextInt();
		System.out.println(info*12 + " inches");
	}
	if (input == 2) { 
		System.out.println(valCon);
		float info = scan.nextFloat();
		System.out.println(info/3 + " yards");
		}
	if (input == 3) { 
		System.out.println(valCon);
		float info = scan.nextFloat();
		System.out.println(info/5280 + " miles");
		}
	if (input == 4) { 
		System.out.println(valCon);
		float info = scan.nextFloat();
		System.out.println(info/1609.344 + " miles");
	
	}
	if (input == 5) { 
		System.out.println("Thanks for using ConverterProgram");
		break;	
	}
		
	if (cont == 0) {
		System.out.println("Would you like to do another converstion?(y/n)");
		String input2 = scan.nextLine();			
		if (input2 == "y") { 
			cont++;			
		}
	
		else  {	
			System.out.println("Thanks for using ConverterProgram");
			break;				
		}
	}
}
		while (cont != 0);
	
	
	}
}
