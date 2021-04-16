package userInput;

import java.util.Scanner;

public class Exercises {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// exercise 1
		int numVowels = 0;

		System.out.println("Type something and I will tell you how many vowels are in what you typed: ");
		String userInput = scan.nextLine().toLowerCase();

		for (int i = 0; i < userInput.length(); i++) {
			char iChar = userInput.charAt(i);
			if (iChar == 'a' || iChar == 'e' || iChar == 'i' || iChar == 'o' || iChar == 'u') {
				numVowels++;
			}
		}

		System.out.println("There are " + numVowels + " vowels in what you typed.");

		// exercise 2

		boolean quit = false;
		System.out.println("Move around?");
		System.out.println("Press 1 to move right.");
		System.out.println("Press 2 to move left.");
		System.out.println("Press 3 to move up.");
		System.out.println("Press 4 to move down.");
		System.out.println("Press q to quit.");

		do {
			
			userInput = scan.nextLine();

			switch (userInput) {
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
			case "q":
				quit = true;
				break;
			default:
				System.out.println(
						"Try again. Acceptable input: [1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program]");
				break;

			}
		} while (quit == false);
		
		System.out.println("Thanks for moving. Or not moving. Either way.");

		scan.close();
	}
}
