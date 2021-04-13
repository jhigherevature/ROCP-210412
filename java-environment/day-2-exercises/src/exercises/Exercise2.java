package exercises;

public class Exercise2 {
/*For this exercise Create an executable class (a class with a main method). 
 * Within the main method create an integer variable called "number" and initialize it to any int value.
 * 
 * Create an if statement below this variable that checks if the value is even or odd. 
 * If the number is even, print "Even value" to the console. If the number is odd, print "Odd value" instead./

 */
	
	public static void main(String[] args) {
		int number = 75;
		if(number  % 2 == 0) {
			System.out.println("Even value");
		} else {
			System.out.println("Odd value");
		}
	}


}
