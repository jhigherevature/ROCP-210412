package oopdesign;

import java.util.Scanner;

public class BookShelf {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mystery mystery = new Mystery("This is a mystery", "The Ghost of New York", "Arthur E. Moody");
		NonFiction birds = new NonFiction("This is about birds", "Birds of North America", "Rob D. Lane");
		Fiction fiction = new Fiction("This is fiction", "Lee", "Sally B. Book");
		int userInput;
		
		System.out.println("What book do you want to read?");
		System.out.println(mystery.name + " - Type 1");
		System.out.println(birds.name + " - Type 2");
		System.out.println(fiction.name + " - Type 3");
		userInput = console.nextInt();
		
		switch(userInput)
		{
		case 1: 
			mystery.Read();
			break;
		case 2:
			birds.Read();
			break;
		case 3:
			fiction.Read();
			break;
		default:
			System.out.println("Select a valid number.");
			break;
		}
		
	}
}