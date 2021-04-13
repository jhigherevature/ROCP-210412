package methodsWithReturnTypes;

public class Return1 {
	public static void main(String[] args) {
		char[] test = getAlphabetArray();
		for (int i = 0; i< 26; i++) {
			System.out.println(test[i]);
		}
	}
	
	static char[] getAlphabetArray() { // method creates array from a-z length of 26
		char[] alph = new char[26];
		char letter = 'a';
		for (int i = 0; i< 26; i++) {
	
			alph[i] = letter;
			letter++;
			
		}
		return alph;
	}
}
