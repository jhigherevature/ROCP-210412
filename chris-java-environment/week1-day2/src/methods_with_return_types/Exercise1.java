package methods_with_return_types;

public class Exercise1 {

	public static void main(String[] args) {
		
		Exercise1 e = new Exercise1();
		char[] letters = e.getAlphabetArray();
		
		System.out.println(letters);

	}
	
	public char[] getAlphabetArray() {
		
		char[] alphabet = new char[26];
		char firstLetter = 'a';
		
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = firstLetter;
			firstLetter++;
			System.out.println(alphabet[i]);
		}
		
		return alphabet;
	}

}
