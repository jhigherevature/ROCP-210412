package nestedLoops;

public class Exercises {

	public static void main(String[] args) {
		int row;
		int col;
		char letter;
		int i;
		String[] firstNames = { "Adam", "Alexis", "Dennis", "Jose", "Jessica", "Meghan", "Memphis", "Nicky", "Sarah",
				"William" };
		String[] lastNames = { "Adamson", "Bond", "Brown", "Johnson", "Gallagher", "Smith", "Thompson", "Perez", "Snow",
				"Tran" };

		// exercise
		for (row = 1; row <= 5; row++) {
			for (col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println("");
		}

		// bonus 1 with... bonus
		for (letter = 'A'; letter <= 'Z'; letter++) {
			omitVowels: for (i = 1; i <= 26; i++) {
				if (i == (letter - ('A' - 1))) {
					switch (letter) {
					case 'A':
						break omitVowels;
					case 'E':
						break omitVowels;
					case 'I':
						break omitVowels;
					case 'O':
						break omitVowels;
					default:
						System.out.println(letter + " - " + i);
					}
					continue;
				}
			}
		}

		// bonus 2
		for (String firstName : firstNames) {
			for (String lastName : lastNames) {
				System.out.println(firstName + " " + lastName);
			}
		}

	}

}
