package gathering_user_input;
import java.util.Scanner;
public class Exercise2 {

	public static void main(String[] args) {
		
		inputGame();
		
	}
	
	public static void inputGame() {
		
		Scanner i = new Scanner(System.in);
		
		System.out.println("Acceptable input: [1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program");
		
		program: while (true) {
			String input = i.nextLine();
			switch (input){
		
				case "1":
					System.out.println("Move right");
					break;
				case "2":
					System.out.println("Move left");
					break;
				case "3":
					System.out.println("Move up");
					break;
				case "4":
					System.out.println("Move down");
					break;
				case "q":
					System.out.println("exit program");
					i.close();
					break program;
				default:
					System.out.println("Try again. Acceptable input: \\[1 - Move right, 2 - Move Left, 3 - Move Up, 4 - Move Down, q - exit program]\\");
		}
		
		}
	}

}
