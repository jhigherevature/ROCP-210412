package main;

import java.util.Scanner;

public class Menu {
	Scanner userInput = new Scanner(System.in);
	
	int getInput(int numOfChoices) {
		int choice = -1;
		do {
			System.out.print("\nEnter your selection: ");
			try {
				choice = Integer.parseInt(userInput.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid selection, numbers only...");
			}
			if (choice < 0 || choice > numOfChoices) {
				System.out.println("\nChoice outside of range, choose again...");
			} 
		} while (choice < 0 || choice > numOfChoices);
		
		return choice;
	}
	
}
