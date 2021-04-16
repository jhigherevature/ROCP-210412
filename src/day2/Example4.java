package day2;

public class Example4 {

	public static void main(String[] args) {
		char[] characters = getAlphabetArray();
		for(int i = 0; i < characters.length; i++)
		System.out.print(characters[i] + " ");
	}

	public static char[] getAlphabetArray() {

		char[] alphabets = new char[26];

		//A = 65
		for(int i = 0; i < alphabets.length; i++) {
			char currentAlphabet = (char)(i + 97);
			
			alphabets[i] = currentAlphabet;
		}
		return alphabets;

		
	}

}
