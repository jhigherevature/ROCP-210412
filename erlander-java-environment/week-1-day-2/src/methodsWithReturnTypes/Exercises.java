package methodsWithReturnTypes;

public class Exercises {

	public static void main(String[] args) {

		char[] letters = getAlphabetArray();
		int i;

		for (i = 0; i < letters.length; i++) {
			System.out.println(letters[i]);
		}

		System.out.println(getPi());
	}

	// exercise
	public static char[] getAlphabetArray() {
		char[] alphabet = new char[26];
		char c = 'a';
		int i;

		for (i = 0; i < alphabet.length; i++) {
			alphabet[i] = c;
			c++;
		}

		return alphabet;
	}

	// bonus
	public static double getPi() {
		return Math.PI;
	}

}
