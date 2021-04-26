package gathering_user_input;

import java.util.Scanner;

public class Exercise2 {

	public static void main(String[] args) {
		
		Scanner scanningInput = new Scanner(System.in);
		while (true) {
			System.out.print("Choose move: (1)");
			String input = scanningInput.nextLine();
			switch (input) {
			
			case "1":
				System.out.println("Move Right");
				break;
				
			case "2":
				System.out.println("Move Left");
				break;
				
			case "3":
				System.out.println("Move Up");
				break;
				
			case "4":
				System.out.println("Move Down");
				break;
				
			case "q":
				System.out.println("exit program");
				scanningInput.close();
				break menu;
				
			default:
				System.out.println("Try again. Acceptable input: [1 - Move Right, 2 - Move left, 3 - Move Up, 4 - Move Down, q - exit program]");
				
				break;
			}
			
		}
		
		scanningInput.close();
			
	}
	
}
