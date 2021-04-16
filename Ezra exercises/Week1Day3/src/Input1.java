import java.util.Scanner;

public class Input1 {
//	public static void main(String[] args) {
//		
//		
//	}
	public static void scannerVowelNum() {
		System.out.println("Give me some of that sweet sweet data");
		Scanner scan = new Scanner(System.in);
//		String S = scan.next();
		String input = scan.nextLine();
		System.out.println("You typed: "+ input);

		int count = 0;
		
		for (int i = 0; i < input.length(); i++) {
			
		switch (input.charAt(i)) {
		case 'a': 
			count++;
			break;
		case 'e':
			count++;
			break;
		case 'i': 
			count++;
			break;
		case 'o':
			count++;
			break;
		case 'u': 
			count++;
			break;
		default:
			break;
		}
		}
		System.out.println("There are " + count + " vowels in your sentence.");
	}
	
	
	
	
}

// bonus 2 for scanner input
//Create a method that prints different statements based on the user's input according to the following cases.
//
//Case One: If the input is 1, then print, “Moving Right”
//Case Two: If the input is 2, then print, “Moving Left”
//Case Three: If the input is 3, then print, “Moving Up”
//Case Four: If the input is 4, then print, “Moving Down”
//Case Five: If the input is ‘q', then exit the program
//Case Six: If the input is anything other than the above, then print, "Try again. Acceptable input: \[1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program\]"
//
//The program should employ a continuous loop and only end if the user types in the letter q.





//Create a method that uses a Scanner to parse any input from the console (System.in) and prints out the number of vowels in the line.
