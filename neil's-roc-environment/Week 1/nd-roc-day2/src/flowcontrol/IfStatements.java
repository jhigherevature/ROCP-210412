package flowcontrol;

public class IfStatements {

	public static void main(String[] args) {
	
		/*
		 * If statements are used to control whether the next line, or the next block of code
		 * will execute in your program.
		 */
		
		int x = 5;
		if(x < 2) {
			System.out.println("X was less than 2.");
			x = 0;
			
		}else if (x == 5) { 
			System.out.println("X was equal to 5");
			
		}else{
			System.out.println("X was greater than 2"); 
			
		}
		
			System.out.println(x);
	}

}

