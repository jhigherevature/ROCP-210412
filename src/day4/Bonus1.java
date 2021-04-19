package day4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bonus1 {

	public static void main(String[] args) {
		Map<String, String> fruitsMap = new HashMap<String, String>();
		fruitsMap.put("apple", "A forbidden fruit");
		fruitsMap.put("banana", "A yellow fruit that can be peeled");
		fruitsMap.put("cantaloupe", "A melon fruit that has an orange flesh");

		loop: while (true) {
			System.out.println("What would you like to do?");
			System.out.print("1 See fruit description, 2 Add fruit, 3 Remove fruit, 4 Edit fruit, 5 Quit: ");
			Scanner scanner = new Scanner(System.in);
			int userOption = Integer.parseInt(scanner.nextLine());
			
			String fruitKey = "";
			String fruitDescription = "";
			
			switch (userOption) {
			case 1:
				System.out.print("Enter fruit: ");
				fruitKey = scanner.nextLine();
				fruitDescription = fruitsMap.get(fruitKey);
				System.out.println(fruitDescription);
				break;
			case 2:
				System.out.print("Enter fruit: ");
				fruitKey = scanner.nextLine();
				System.out.print("Enter description: ");
				fruitDescription = scanner.nextLine();
				fruitsMap.put(fruitKey, fruitDescription);
				break;
			case 3:
				System.out.print("Enter fruit: ");
				fruitKey = scanner.next();
				fruitsMap.remove(fruitKey, fruitDescription);
				break;
			case 4:
				System.out.print("Enter fruit: ");
				fruitKey = scanner.nextLine();
				System.out.print("Enter new description: ");
				fruitDescription = scanner.nextLine();
				fruitsMap.put(fruitKey, fruitDescription);
				break;
			case 5:
				break loop;
			}
			System.out.println();
		}

	}

}
