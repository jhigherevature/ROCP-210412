package gathering_user_input;

import java.util.Scanner;

public class ExerciseTwo {
	public static void directions() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Which direction do you want to go?\n[input options:1,2,3,4,q]" );
		
		String input = s.nextLine();
		
		switch (input) {
			case "1":
				System.out.println("Moving Right\n");
				directions();
				break;
				
			case "2":
				System.out.println("Moving Left\n");
				directions();
				break;
				
			case "3":
				System.out.println("Moving Up\n");
				directions();
				break;
				
			case "4":
				System.out.println("Moving Down\n");
				directions();
				break;
				
			case "q":
;
				break;
				
			default:
				System.out.println("Try again. Acceptable input:"
						+ " \\[1 - Move right, 2 - Move Left,"
						+ " 3 - Move Up, 4 - Move Down, q - exit program\\]");
				directions();
		
		}
		s.close();
		
		
	}
}
