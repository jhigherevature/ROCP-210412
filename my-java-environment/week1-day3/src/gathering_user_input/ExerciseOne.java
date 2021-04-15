package gathering_user_input;

import java.util.Scanner;

public class ExerciseOne {

	static void VowelCount() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Input that you want the number of vowels:");
		
		
		String input = s.nextLine();
		String lower = input.toLowerCase();
		
		int count = 0;
		for (int i = 0; i<lower.length(); i++) {
			
			if (lower.charAt(i) == 'a' ||
					lower.charAt(i) == 'e' || 
					lower.charAt(i) == 'i' || 
					lower.charAt(i) == 'o' || 
					lower.charAt(i) == 'u') {
				count ++;
			}
		}

		System.out.println("Number of vowels in '" + input + "' is " + count + ".");
		
		s.close();
	}
	
	
}
