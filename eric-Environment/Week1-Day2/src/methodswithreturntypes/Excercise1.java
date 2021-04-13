package methodswithreturntypes;

public class Excercise1 {

	public static void main(String[] args) {
		
		Excercise1 e = new Excercise1();
		char[] returned = e.getAlphabetArray();//I included this to confirm I did return an array with the chars 'a' through 'z'
		
		System.out.println(returned);//I did this to show the array that was returned includes the chars 'a' through 'z'
		
	}
	
	public char[] getAlphabetArray() {
		
		char[] alphabet = new char[26];
		char letter = 'a';
		
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = letter;
			letter++;
			System.out.println(alphabet[i]);
		}
		
		return alphabet;
		
	}
	
}
