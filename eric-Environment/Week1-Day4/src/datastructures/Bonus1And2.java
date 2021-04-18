package datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bonus1And2 {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("apple", "A forbidden fruit");
		map.put("banana", "A yellow fruit that can be peeled");
		map.put("cantaloupe","A melon fruit that has an orange flesh");
		
		Scanner input = new Scanner(System.in);
		
		program:while(true) {
			
			System.out.println("Choose an option: \nA. Check dictionary \nB. Add to dictionary \nC. Remove from dictionary \nD. Exit");
			String letter = input.nextLine();
			
			switch (letter.toLowerCase().intern()) {
			
			case "a": {
			System.out.println("type a word to see its definition:");
			String word = input.nextLine();
			System.out.println(map.get(word));
			break;
			}
			case "b": {
			System.out.print("Enter the word you wish to add to the dictionary: ");
			String entryKey = input.nextLine();
			System.out.print("\nEnter the word's definition: ");
			String entryDef = input.nextLine().toLowerCase();
			map.put(entryKey, entryDef);
			System.out.println("Your new word is " + entryKey + " and its definition is: " + entryDef);
			break;
			}
			case "c": {
			System.out.print("Choose a word to remove from the dictionary:");
			String remove = input.nextLine();
			if (map.containsKey(remove)) {
				map.remove(remove);
				System.out.println(remove + " has been removed from the dictionary");
			}
			else {
				System.out.println("That word is not in the dictionary");
			}
			break;
			}
			case "d":{
			System.out.println("Goodbye");
				break program;
			}
			default: break;
			}
		}
		
		input.close();
		
	}

}
