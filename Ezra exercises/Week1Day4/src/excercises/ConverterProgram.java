package excercises;

import java.util.Scanner;
import java.io.*;

public class ConverterProgram {

	public static void main(String...args) {
	
		String valCon = "Enter a value to convert: ";
		int cont = 1;

		do {
		System.out.println("Select a conversion:\n 1. Feet to Inches\n 2. Feet to Yards\n 3. Feet to Miles\n 4. Meters to Miles");
		}
		while (cont==1) {
			System.out.println("Would you like to convert something?");
			
		
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
	
	
	if (input == 1) { 
		System.out.println(valCon);
		int info = scan.nextInt();
		System.out.println(info*12 + " inches");
	}
	if (input == 2) { 
		System.out.println(valCon);
		int info = scan.nextInt();
		System.out.println(info/3 + " yards");
		}
	if (input == 3) { 
		System.out.println(valCon);
		int info = scan.nextInt();
		System.out.println(info/5280 + " miles");
		}
	if (input == 3) { 
		System.out.println(valCon);
		int info = scan.nextInt();
		System.out.println(info/1609.344 + " miles");
		}
		}
	
	
}
}
