package datastructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BonusOne {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, String> map = new HashMap<String, String>(); 
		map.put("apple", "A forbidden fruit");
		map.put("banana", "A yellow fruit that can be peeled");
		map.put("cantaloupe", "A melon fruit that has an orange flesh");
		
		System.out.println("Type either apple, banana, or cantaloupe");
		String input = console.next();
		System.out.println(map.get(input));
	}
}