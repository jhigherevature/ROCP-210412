package datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BonusOne {
	public static void main(String[] args) {
		Map <String, String> fruits = new HashMap <String, String>();
		fruits.put("apple", "A forbidden fruit");
		fruits.put("banana", "A yellow fruit that can be peeled");
		fruits.put("cantaloupe", "A melon fruit that has an orange flesh");
		
		
		Scanner s = new Scanner(System.in);
		System.out.println("Type a Fruit:");
		String input = s.nextLine();
		String def = (String)fruits.get(input);
		
		System.out.println(input + "'s definition: " + def);
		
		
	}
}
