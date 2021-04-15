package nestedLoops;

public class Bonus1 {
	
	public static void main(String[] args) {
		
		char[] letterArray = new char[26];
		char[] vowels = {'A', 'E', 'I', 'O', 'U'};
		int[] numberArray = new int[26];
		char letter = 'A';
		int number = 1; 		

		for (int letterIndex = 0; letterIndex < letterArray.length; letterIndex++) {
			
			letterArray[letterIndex] = letter;
			letter++;
		
		}
		
		for (int numberIndex = 0; numberIndex < numberArray.length; numberIndex++) {
			
			numberArray[numberIndex] = number;
			number++;
			
		}
		
		for (int numberRow = 1; numberRow <= numberArray.length; numberRow++) {
			
			System.out.println(letterArray[numberRow-1] + " - " + numberArray[numberRow-1]);
			
		}
	
	}

}
