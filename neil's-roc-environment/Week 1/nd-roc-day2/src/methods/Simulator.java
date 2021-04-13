package methods;


public class Simulator {
	
	public static void main(String[]args) {
		System.out.println(add(5,10));
		System.out.println(add(20,15));
		System.out.println(add(500,1000));
		
	}
	
	public static int add(int a, int b) {
		int sum = a + b;
		
		/*
		 * the return keyword allows you to use the method as you would an expression
		 * by using the value immediately to the left of the keyword.
		 * 
		 * the return keyword also stops* any code below from executing.
		 */
		return sum;
	}

}
