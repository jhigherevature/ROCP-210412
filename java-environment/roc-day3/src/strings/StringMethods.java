package strings;

public class StringMethods {
	public static void main(String[] args) {
		String words = "Hello World My Name Is Joseph";
		
		System.out.println(words.toLowerCase());
		System.out.println(words);
		
		String input = "No";
		
		if (input.toLowerCase().intern() == "no") {
			System.out.println("Does this print?");
		}
		
		/*
		 * equalsIgnoreCase, as its name implies
		 * performs an equivalency check, but ignores
		 * the upper or lowercase letters for the
		 * strings
		 */
		if (input.equalsIgnoreCase("no")) {
			System.out.println("Does this print second try?");
		}
		
		/*
		 * The overloaded version of Substring which
		 * takes a second index argument does not 
		 * include the second indexed letter...
		 * inclusive of first index
		 * exclusive of second index
		 */
		System.out.println("Substring, 6 to 13: " + words.substring(6, 13));
		
		String[] word = words.split("o");
		
		System.out.println("Array printing from word");
		for (String w : word) {
			System.out.println(w);
		}
	}
}
