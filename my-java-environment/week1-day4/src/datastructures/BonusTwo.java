package datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BonusTwo {
	public static void main(String[] args) {
			initDictionary();
			
		}
		
		// Initializes dictionary with given inputs
		public static void initDictionary() {
			
			// Initialize Dictionary
			Map <String, String> dict = new HashMap<String, String>();
			dict.put("apple", "A forbidden fruit");
			dict.put("banana", "A yellow fruit that can be peeled");
			dict.put("cantaloupe", "A melon fruit that has an orange flesh");
			openDictionary(dict);
			
		
	}

		// Opening the dictionary with the initialized dictionary declared
		private static void openDictionary(Map <String,String> dict) {
			
			// Create Scanner for Inputs
			Scanner s = new Scanner(System.in);
			System.out.println("\n************");
			System.out.println("What would you like to do? [1,2,3,q]");
			System.out.println("[1] - Search Dictionary");
			System.out.println("[2] - Add a Definition");
			System.out.println("[3] - Modify a Definition");
			System.out.println("[q] - Stop Using the Dictionary");
			
			String input1 = s.nextLine();
			
			// Switch case for input to determine what to do next
			switch(input1) {
			
			case "1":
				searchDictionary(dict);
				break;
				
			case "2":
				addDictionary(dict);
				break;
				
			case "3":
				modDictionary(dict);
				break;
				
			case "q":
				System.out.println("\nClosing Dictionary");
				System.exit(0);
				break;
				
				
			default:
				System.out.println("\nInvalid input, try again");
				openDictionary(dict);     
				break;
			
			}
		
		}
		
		// Method to Search the Dictionary
		private static void searchDictionary(Map <String,String> dict){
			
			// Create Scanner for Inputs
			Scanner s = new Scanner(System.in);
			
			System.out.println("\n************");
			System.out.println("What word would you like to look up?");
			System.out.println("(type [main menu] to return to the main menu)");
			
			String input2 = s.nextLine().toLowerCase();
			
			
			// Gives User Option to Go Back to Main Menu
			if (input2.equals("main menu")) {
				openDictionary(dict);
				
				}
			
			else {
				// Converts input to lower to ignore casing
				String def = (String)dict.get(input2);		
				
				// Checks if the Input is not the Dictionary
				if (def == null) {
					System.out.println("\n" + input2 + " is not in the dictionary");
					System.out.println("Go back to main menu to add it");
					
				}
				
				//Prints Word and Definition
				else {
					System.out.println("\n" + input2 + "'s definition: " + def);
				
				}
				
				// Allows User to Search for Another Word
				searchDictionary(dict);
				
				}
				
		}

		// Method to add Word to Dictionary
		private static void addDictionary(Map <String,String> dict) {
			Scanner s = new Scanner(System.in);
			
			System.out.println("\n************");
			System.out.println("New Word:");
			System.out.println("(type [main menu] to return to the main menu)");
			String newWord = s.nextLine().toLowerCase();
			
			if (newWord.equals("main menu")) {
				openDictionary(dict);
				
				}
			
			String def = (String)dict.get(newWord);		
			
			// Checks if the Input is not the Dictionary
			if (def != null) {
				System.out.println("\n"+ newWord + " is already in the dictionary");
				System.out.println("~\n" + newWord + "'s definition: " + def + "\n~");
				System.out.println("To modify this word's definition, return to main menu");
				addDictionary(dict);
				
			}
			
			else { 
				System.out.println("\nDefinition:");
				String newDefinition = s.nextLine();
				
				System.out.println("\nPlease Confirm:");	
				System.out.println(newWord + "'s definition: " + newDefinition);
				System.out.println("[y] - yes");
				System.out.println("[n] - no");
				String confirm = s.nextLine();
				
				switch (confirm) {
				
				case "y": {
					dict.put(newWord, newDefinition);
					System.out.println("Word and definition added");
					addDictionary(dict);
					break;
					
				}
				
				case "n":  {
					System.out.println("Word and definition not added");
					addDictionary(dict);
					break;
					
				}
				
				default: {
					System.out.println("Invalid input, try again");
					addDictionary(dict);
					break;
					
				}
				
				}
			}
		


			
			

		}
		
		//Method to Modify a Word's Definition
		private static void modDictionary(Map <String,String> dict) {
			Scanner s = new Scanner(System.in);
			
			System.out.println("\n************");
			System.out.println("Word to Modify:");
			System.out.println("(type [main menu] to return to the main menu)");
			String modWord = s.nextLine().toLowerCase();
			
			if (modWord.equals("main menu")) {
				openDictionary(dict);
				
				}
			
			String currentDef = (String)dict.get(modWord);
			
			if (currentDef == null) {
				System.out.println("\n" + modWord + " is not in the dictionary");
				System.out.println("Go back to main menu to add it");
				modDictionary(dict);
			}
			
			else {
				System.out.println("~\n" + modWord + "'s current definition: " + currentDef + "\n~");
				System.out.println("Would you like this change this word's definition?");
				System.out.println("[y] - yes");
				System.out.println("[n] - no");
				String confirm = s.nextLine();
				
				if (confirm.equals("y")) {
					System.out.println("\nEnter " + modWord + "'s new definition:");
					String newDefinition = s.nextLine();
					
					System.out.println("\nPlease Confirm:");	
					System.out.println(modWord + "'s definition: " + newDefinition);
					System.out.println("[y] - yes");
					System.out.println("[n] - no");
					String confirm2 = s.nextLine();
					
					if (confirm2.equals("y")) {
						dict.replace(modWord, newDefinition);
						System.out.println("Definition updated");
						modDictionary(dict);
						
					}
					
					else if (confirm2.equals("n")) {
						System.out.println("Definition not updated");
						modDictionary(dict);
						
					}
					
					else {
						System.out.println("Invalid input, try again");
						modDictionary(dict);
					}
					
					
					dict.put(modWord.toLowerCase(), newDefinition);
					System.out.println("Word and definition added");
					modDictionary(dict);
					
				}
				
				else if (confirm.equals("n")) {
					System.out.println("Word's definition not changed");
					modDictionary(dict);
					
				}
				
				else {
					System.out.println("Invalid input, try again");
					modDictionary(dict);
				}
				
			}
			
			
		}
			
		
			
			
		
		
		
		
		
		
		

		
	
}
