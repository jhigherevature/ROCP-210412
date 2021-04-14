package flowcontrol;

public class IfStatements {

	public static void main(String[] args) {
		/*
		 * If statements are used to control 
		 * whether the next line, or the next block 
		 * of code will execute in your program.
		 */
		int x = 5;
		/*
		 * Semi-colons are used to indicate the end
		 * of a statement. When they are placed 
		 * immediately following an if-statement condition
		 * (or any flow control statement) it will cause
		 * the flow control statement to do no actions
		 */
		if (x < 0);	{
			System.out.println("X was less than 0");
		}
		
		if (x < 2) {
			System.out.println("X was less than 2");
			x = 0;
		} else if (x < 10) { 
			System.out.println("X was less than 10");
		} else if (x == 5) {
			System.out.println("X is equal to 5");
		} else {
			System.out.println("X was greater than 2");
			x = 15;
		}

//		System.out.println(x);
		
		int age = 14;
		boolean withParent = true;
		if (age > 17) {
			System.out.println("You can watch rated R movies");
		} else if (age > 13) {
			if (withParent)
				System.out.println("You can watch rated R movies");
			else {
				System.out.println("You can watch T rated movie");
			}
		} else if (age > 10) {
			if (withParent) {
				System.out.println("You can watch T rated movies");
			} else {
				System.out.println("You can watch E rated movies");
			}
		}
	}

}
