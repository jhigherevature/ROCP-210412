package gathering_user_input;

import java.util.Scanner;

public class ExerciseTwo {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String i;
		do
		{
			System.out.println("1 - Move right, 2 - Move Left, 3 - Move Up, 4 Move Down, q - exit program");
			i = console.next();
			
			switch(i)
			{
			case "1": 
				System.out.println("Moving Right");
				break;
			case "2":
				System.out.println("Moving Left");
				break;
			case "3":
				System.out.println("Moving Up");
				break;
			case "4":
				System.out.println("Moving Down");
				break;
			case "q":
				return;
			default: 
				System.out.println("Try again. Acceptable input: [1 - Move right, 2 - Move Left, " +
			"3 - Move Up, 4 - Move Down, q - exit program");
			}
		}
		while(i != "q");
	}
}
