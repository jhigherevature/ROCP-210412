package scanner;

import java.util.*;

public class ScannerBasics {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// print message to console, for user
		System.out.println("Give me input");

		/*
		 * nextLine will take the entire line of
		 * input from my console (that I type) and 
		 * store it within my String input.
		 */
//		String input = scan.nextLine();
		
		int input = scan.nextInt();
		System.out.println("You typed: " + input);
		
		/*
		 * When you close a resource, it cannot be reopened
		 */
		scan.close();
		
		// the below will give us an error because we closed the resource above
		Scanner other = new Scanner(System.in);
		System.out.println("Give me another number");
		input = other.nextInt();
		System.out.println(input);
	}
}
