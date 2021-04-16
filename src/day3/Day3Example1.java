package day3;

import java.util.Scanner;

public class Day3Example1 {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		numberOfVowels();
      scanner.close();
	}

	public static void numberOfVowels() {

		String input = scanner.next();
        //Akwasi
		//['A']['k']['w']['a']['s']['i']
		int vowelCount = 0;
	
		for (int i = 0; i < input.length(); i++) {
			char charAtPositionI = input.charAt(i);

			switch (charAtPositionI) {
			case 'a':
				vowelCount++;
				break;
			case 'e':
				vowelCount++;
				break;
			case 'i':
				vowelCount++;
				break;
			case 'o':
				vowelCount++;
				break;
			case 'u':
				vowelCount++;
				break;
			}
		}
		
		System.out.print("The number of vowels is "+ vowelCount);
	}
}

