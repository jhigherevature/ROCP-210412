package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercises {

	public static void main(String[] args) {

		// exercise 1
		List<String> arrList = new ArrayList<String>();

		arrList.add("Jaque");
		arrList.add("Alex");
		arrList.add("Carrie");
		arrList.add("Ignacio");
		arrList.add("Byron");
		arrList.add("Gordon");
		arrList.add("Hazel");
		arrList.add("Max");
		arrList.add("Stephanie");
		arrList.add("Dev");
		arrList.add("Eric");
		arrList.add("Faith");

		for (String s : arrList) {
			System.out.println(s);
		}

		// bonus 1 & 2
		Map<String, String> dictionary = new HashMap<String, String>();

		dictionary.put("apple", "A forbidden fruit");
		dictionary.put("banana", "A yellow fruit that can be peeled");
		dictionary.put("cantaloupe", "A melon fruit that has an orange flesh");

		Scanner scan = new Scanner(System.in);
		String choice;
		boolean quit = false;

		while (!quit) {
			System.out.println("What would you like the definition for? (Or press q to quit)");

			String input = scan.nextLine().toLowerCase();
			if (input.equals("q")) {
				quit = true;
				System.out.println("Bye.");
				continue;
			}

			if (dictionary.get(input) != null) {
				System.out.println(dictionary.get(input));
				System.out.println("Would you like to change the definition? Y/N");
				choice = scan.nextLine().toLowerCase();
				if (choice.equals("y")) {
					addWord(input, dictionary, scan);
				} else {
					System.out.println("Would you like to remove that word? Y/N");
					choice = scan.nextLine().toLowerCase();
					if (choice.equals("y")) {
						dictionary.remove(input);
					} else {
						continue;
					}
					continue;
				}
			} else {
				System.out.println("Sorry. I don't know the definition of that word. Would you like to add it? Y/N");
				choice = scan.nextLine().toLowerCase();
				if (choice.equals("y")) {
					addWord(input, dictionary, scan);
				} else {
					continue;
				}
			}
		}
		scan.close();

	}

	public static void addWord(String word, Map<String, String> dictionary, Scanner scan) {

		System.out.println("What is the definition of " + word + "?");
		String userDefinition = scan.nextLine();
		dictionary.put(word, userDefinition);
		System.out.println(word + ": " + dictionary.get(word));
	}

}
