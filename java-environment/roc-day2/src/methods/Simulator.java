package methods;

public class Simulator {
	public static void main(String[] args) {
//		System.out.println(add(5,10));
//		System.out.println(add(20,15));
//		System.out.println(add(500,1000));
		
		/*
		 * Argument are the values that we give
		 * to our methods, when we invoke them.
		 * 
		 * arugments - 5, 10
		 */
//		int value = add(5,10);
		
		Dog d = new Dog("Fido", 7, "Golden Retriever");
		d.bark();
		
		System.out.println(d.value);
		Dog.bark();
		
		Dog two = new Dog("Scooby", 15, "Great Dane");
		two.value = 100;
		System.out.println(d.value);
		System.out.println(two.value);
		
		System.out.println(d == two);
	}
	
	/*
	 * Parameters are the placeholders for data
	 * we can give to our methods.
	 * 
	 * Parameters are the list we declare, during
	 * method creation (declaration)
	 * 
	 * Parameters add: a, b 
	 */
	public static int add(int a, int b) {
		System.out.println(a);
		System.out.println(b);
		int subtracted = b - 4;
		
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
