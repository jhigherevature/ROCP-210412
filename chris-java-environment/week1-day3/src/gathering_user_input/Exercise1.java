package gathering_user_input;

import java.util.Scanner;

public class Exercise1 {

	public static void main(String[] args) {
		
		Scanner vowelCounter = new Scanner(System.in);
		System.out.println("Enter a word or phrase: ");
		String input = vowelCounter.nextLine();
		int numberOfVowels = 0;
		char[] vowels = { 'a', 'e', 'i', 'o', 'u'};
		for (int i = 0; i < input.length(); i++) {
			for (char c : vowels) {
				if (c == input.charAt(i)) {
					++numberOfVowels;
					break;
				}
			}
		}
		
		System.out.println("Your phrase has " + numberOfVowels + " vowels in it.");
		vowelCounter.close();
		

	}

}
