package flowcontrol;

public class SwitchStatement {

	public static void main(String[] args) {
		String letter = "E";
		/*
		 * switch statements compare a variable provided
		 * against case statements. When a match is
		 * found we will begin executing code associated
		 * with that case statement.
		 * 
		 * switch statements use fall-through logic. 
		 * This means once a case is found to match our
		 * variable, we will continue executing code in
		 * the proceeding case statements, until we hit
		 * a break return or continue keyword or the 
		 * end of the switch statement
		 * 
		 * The default keyword is used to provide 
		 * functionality similar to the 'else' keyword
		 * in an if-else statement block. It will 
		 * execute functionality when no other matches
		 * are found across the case statements.
		 * 
		 * The default statement can be placed anywhere
		 * within the switch statement, but usually is
		 * located at the top or bottom.
		 */
		switch (letter) {
		case "A":
			System.out.println("A for Assembly");
			break;
		case "B":
			System.out.println("B for Binary");
			break;
		case "C":
			System.out.println("C for Compiling!");
			break;
		default:
			System.out.println("No match found!");
		}

	}

}
