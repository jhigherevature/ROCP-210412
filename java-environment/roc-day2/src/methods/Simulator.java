package methods;

public class Simulator {

	public static void main(String[] args) {
		System.out.println(add(5,10));
		System.out.println(add(20,15));
		System.out.println(add(500,1000));
		
		int value = add(5,5);
		
	}
	
	public static int add(int a, int b) {
		int sum = a + b;
		/*
		 * The return keyword allows you to use
		 * the method as you would an expression
		 * by using the value immediately to the 
		 * left of the keyword.
		 * 
		 * The return keyword also stops* the 
		 * functionality within your method at 
		 * that line
		 */
		return sum;
//		System.out.println("The sum was: " + sum);
	}
}
