package methodsWithReturnTypes;

public class Exercise1 {
	
	public static void main(String[] args) {
		
		System.out.println(getAlphabetArray());
		System.out.println(getPi());
		
	}
	
	public static char[] getAlphabetArray() {
		
		char[] alphabetArray = new char[26];
		char letters = 'a';
			for (int index = 0; index < alphabetArray.length; index++) {
			
				alphabetArray[index] = letters;
				letters++;
			}
			
			return alphabetArray;
	}
	//bonus in here because it was tiny
	public static double getPi() {
		
		double pi = Math.PI;
		
		return pi;
	}
}
