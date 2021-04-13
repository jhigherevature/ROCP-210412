package operators;

public class Ternary {
	
	/*
	 * Ternary operators act as a shorthand for a basic if-else statement, 
	 * Syntax:
	 * (condition) ? expToReturnIfTrue : expTo ReturnIfFalse
	 * 	 */
	
	public static void main(String[] args) {
			int x = (true) ? 15 : 25;
			int y = (false) ? 15 : 25;
			System.out.println(x);
			System.out.println(y);

	}
}
