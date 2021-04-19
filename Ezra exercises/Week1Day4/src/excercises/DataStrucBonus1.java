package excercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataStrucBonus1 {

	public static void main(String[] args) {

	Map<String, String> Fruit = new HashMap<String, String>();
	Fruit.put("apple", "A forbidden fruit");
	Fruit.put("banana", "A yellow fruit that can be peeled");
	Fruit.put("cantaloupe", "A melon fruit that has an orange flesh");

	System.out.println("Choose a fruit");
	Scanner scan = new Scanner(System.in);
	String input = scan.nextLine();
	System.out.println(Fruit.get(input));
	
	int inputC = 0;			
	while (inputC != 6) {
	
	System.out.println("Would you like to:");
	System.out.println("1 Edit a fruit");
	System.out.println("2 Remove a fruit");
	System.out.println("3 Add a fruit");
	System.out.println("4 List all fruits");
	System.out.println("5 Quit");

	inputC = scan.nextInt();
		
	
	switch(inputC) {
case 1:
	System.out.println("Choose fruit to edit");
	String name = scan.nextLine();
	System.out.println("What is new definition");
	String def = scan.nextLine();
	Fruit.put(name, def);
	break;
case 2:
	System.out.println("Choose fruit to remove");
	input = scan.nextLine();
	Fruit.remove(input);
	break;
case 3:
	System.out.println("Choose fruit to add");
	input = scan.nextLine();
	System.out.println("What is new definition");
	def = scan.nextLine();
	Fruit.put(input, def);
	break;
case 4:
	System.out.println("All fruits in dictionary:");
	for (Map.Entry<String, String> entry : Fruit.entrySet()) {
		System.out.println(entry.getKey() +": " + entry.getValue());

	}
	break;
case 5:
	inputC=6;
	break;
default: 	
	break;
	}
	}
	}
}
	

//For this exercise, create an executable class with a main method. Within this main method declare a reference variable for a Map object which accepts String values paired with other String values. Use the put method on this reference variable to add the following key and value pairs:
//
//```java
//"apple", "A forbidden fruit"
//"banana", "A yellow fruit that can be peeled"
//"cantaloupe", "A melon fruit that has an orange flesh"
//```
//
//Next, create a scanner object and ask for input from the user. Use the string input from the user to print the definitions from your dictionary based on the key that is received from the user. i.e. if the user types "apple" then the definition "A forbidden fruit", should print to the console.
//
//**Note**: The `get` method of dictionaries can be used to retrieve the value based on the key provided.

//For this exercise, expand on your dictionary by allowing users to add definitions, remove definitions or edit existing definitions of words.