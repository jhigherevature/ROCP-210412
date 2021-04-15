package nested_loops;

public class BonusOne {

	public static void main(String[] args) {
		char alpha = 'A';
		// Normal Print
		for (int i = 0; i < 26; i++) {
			
			System.out.println((char) (alpha+i) + " - " + (i+1));	
		}
		
		// Print with No Vowels
		for (int i = 0; i < 26; i++) {

			if ((alpha + i) == 'A' ||
					(alpha + i) == 'E' ||
					(alpha + i) == 'I' ||
					(alpha + i) == 'O' ||
					(alpha + i) == 'U')  {	
			}
			else {
			System.out.println((char) (alpha+i) + " - " + (i+1));	
			}
		}
	}

}
