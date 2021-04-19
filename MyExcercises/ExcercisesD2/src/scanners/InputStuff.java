package scanners;

import java.util.Scanner;

public class InputStuff {
	
	
	
	
	public static int vowels(String str) {
		int howmanyvowels = 0;
		
		for(int v = 0; v < str.length() ; v++) {
			char name = str.charAt(v);
			if(name == 'A' || name == 'a' || name == 'E'|| name == 'e' || name == 'I'
					|| name == 'i' || name == 'o' || name == 'O' || name == 'U' || name == 'u') {
			howmanyvowels++;
			}
			
		}
		
		return howmanyvowels;
		
	}
	
	
	public static void directions(Scanner input ) {
	
	
		
		// looping the ask for user to input directions
		while (true) {
			String directionInput = "";
			
			
			System.out.println("What direction would you like to move");
			
			directionInput = input.nextLine();
			
			
			
			if (directionInput.equals("q")) {
				System.out.println("Exit Program");
			break;
			}else if (directionInput.equals("1")) {
				System.out.println("Move Right");
			}else if (directionInput.equals("2")) {
				System.out.println("Move Left");
			}else if (directionInput.equals("3")) { 
				System.out.println("Move up");
			}else if (directionInput.equals("4")) { 
				System.out.println("Move down");
			}else  
				System.out.println("Try again. Acceptable input: [1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program]");
		}

	}
	/*	
	*	switch (nums) {
	*	case "1":
	*		System.out.println("Move right");
	*		break;
	*	
	*	case "2": 
	*		System.out.println("Move left");
	*		break;
	*	
	*	case "3": 
	*		System.out.println("Move up");
	*		break;
	*
 	*	case "4":
	*		System.out.println("Mover Down");
	*		break;
	*
	*	case "q":
	*		System.out.println("Exit Program");
	*		break;
	*		
	*	default:
	*		System.out.println("Try again. Acceptable input: [1 - Move right, 2 - Move Left, 3 - "
	*				+ "Move Up, 4 - Move Down, q - exit program]");
	*		break;
	*	}
	*/
	//	return nums;
		

	
	
	
	

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
			
		System.out.println("What is your Name");
		String str = input.next();
		
		int name = vowels(str);
		System.out.println(name);
		
		
		System.out.println(" what direction would you like to move:Acceptable input: [1 - Move right, 2 - Move Left, 3 - "
		           			+ "Move Up, 4 - Move Down, q - exit program]");
		
		directions(input);
	
		input.close();
	}
}
