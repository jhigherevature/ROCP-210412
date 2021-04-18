package datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BonusTwo {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> map = new HashMap<String, String>(); 
		int userInput = 0;
		String word;
		String definition;
		
		map.put("apple", "A forbidden fruit");
		map.put("banana", "A yellow fruit that can be peeled");
		map.put("cantaloupe", "A melon fruit that has an orange flesh");
		
		do
		{
			System.out.println("Please enter one of these options. 1 - Add Definition, 2 - Remove Definition, 3 - Edit Definition, 4 - View Definition.");
			userInput = console.nextInt();
			switch(userInput)
			{
			case 1:
				System.out.println("Enter the new word.");
				word = console.next();
				word = word.toLowerCase();
				System.out.println("Enter its defintion.");
				definition = console.next();
				definition = definition + console.nextLine();
				definition = definition.toLowerCase();
				map.put(word, definition);
				break;
			case 2:
				System.out.println("Enter the word whose definition you'd like to remove.");
				word = console.next();
				word = word.toLowerCase();
				map.remove(word);
				break;
			case 3:
				System.out.println("Enter the word whose definition you'd like to edit.");
				word = console.next();
				word = word.toLowerCase();
				System.out.println("Enter the new definition.");
				definition = console.next();
				definition = definition + console.nextLine();
				definition = definition.toLowerCase();
				map.replace(word, definition);
				break;
			case 4:
				System.out.println("Enter the word whose definition you'd like to see.");
				word = console.next();
				word = word.toLowerCase();
				if(map.get(word) == null)
				{
					System.out.println("No entry for this word.");
				}
				else
				{
					System.out.println(map.get(word));
				}
				break;
			default:
				System.out.println("Please enter a valid number.");
				break;
			}
			System.out.println("Want to select another option? Press 1 or any other key to exit.");
			userInput = console.nextInt();
		}
		while(userInput == 1);
	}
}
