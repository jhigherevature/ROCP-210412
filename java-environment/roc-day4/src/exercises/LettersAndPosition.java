package exercises;

public class LettersAndPosition {
	
	public static void main(String[] args) {
		int i = 1;
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			System.out.print(letter + " - ");
			for ( ; ; ) {
				System.out.println(i);
				i++;
				break;
			}
		}
	}
	/*
	 * switch (input.charAt(i)) {
	 * 		case 'a':
	 * 			break;
	 * 		case 'e':
	 * 			break;
	 * 		case 'i':
	 * 			break;
	 * }
	 */
}
