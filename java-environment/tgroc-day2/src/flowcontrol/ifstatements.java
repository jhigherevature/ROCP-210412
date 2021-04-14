package flowcontrol;

public class ifstatements {
	
	public static void main(String[] args) {
		/*
		 * if statements are used to control wether
		 * the next line, or thenext block of code
		 * will execut in your program
		 */
		int x = 5;
		
		/*
		 * semi-colons are used to indicate the end
		 * of a statement . When they are placed immediately following an if-statement conditions
		 * (or any flow contral statement
		 */
		
		if (x < 2) {
			System.out.println("x was less than 2");
			x = 0;
		} else if (x < 10) {
			System.out.println("X was less than 10");
		}
		else if (x == 5) {
			System.out.println("x is equal to 5");
		} else {
			System.out.println("x was greater than 2");
			x =15;
			
		}
			System.out.println(x);
			
			int age = 14;
			boolean withParent = true;
			
			if (age > 17) {
				System.out.println("You can watch this rated R");
			} else if (withParent) {
				if (age > 13)
					System.out.println("you can watch Rated R movies");
				else {
					System.out.println("You can watch T reated movies");
				}
			} else if (age > 10) {
				if (withParent) }
			System.out.println("you can watch");
				
				}
				else ()System.out.println("you cannot watch this movie");
			}
		
	}

}
