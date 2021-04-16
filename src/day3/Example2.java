package day3;

import java.util.Scanner;

public class Example2 {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		printDifferentStatement();
	}

	public static void printDifferentStatement() {

		String input = "";
		
		while (true) {
			
		 input = scanner.next();
		 
		 if(input.equals("q"))
			 break;

			switch (input) {
			case "1":
				System.out.println("Moving Right");
				break;
			case "2":
				System.out.println("Moving Left");
				break;
			case "3":
				System.out.println("Moving Up");
				break;
			case "4":
				System.out.println("Moving Down");
				break;
			default:
				System.out.println("Try again");
			}
		}
		
	}
		
}
