package gatheringUserInput;

import java.util.Scanner;

public class Exercises {
	
	public static Scanner userInput = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println(vowelAmount());
		runAround();
		userInput.close();
	}
	public static int vowelAmount() {
		
		int counter = 0;
		
		System.out.println("Type a word");
		String input = userInput.nextLine();
		
		
		 for (int index = 0; index < input.length(); index++) {
					
				 char x = input.toLowerCase().charAt(index);
			
				 if (x == 'a'|| x == 'e' || x == 'i' || x == 'o' || x == 'u') {
				
					 counter++;
				 } else {
				
					 continue;
				 }
				 
		}
			
		return counter;
		
		
	}
	public static void runAround() {
		
		System.out.println("Make a move (1, 2, 3, 4) q = exit");
		
		loop: for (;;) {
			
			String input = userInput.nextLine();
			
			choice: switch (input) {
			
			case "1":
				System.out.println("Moving Up...");
				System.out.println("Next move?");
				break choice;
			
			case "2":
				System.out.println("Moving Left...");
				System.out.println("Next move?");
				break choice;
				
			case "3":
				System.out.println("Moving Right...");
				System.out.println("Next move?");
				break choice;
				
			case "4":
				System.out.println("Moving Down...");
				System.out.println("Next move?");
				break choice;
					
			case "q":
				System.out.println("Goodbye");
				break loop;
				
			default:
				System.out.println("Try again. Acceptable input: [1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program]");
			}
			
		}
		
	}
}
