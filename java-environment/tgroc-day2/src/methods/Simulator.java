package methods;

public class Simulator {
	
	public static void main(String[] args) {
		System.out.println(add(5,10));
		System.out.println(add(20,15));
		System.out.println(add(500,1000));
	}
	
	/*
	 * parameters are the placeholders for data 
	 * we can give to our methods
	 * 
	 * perameters are list we declare, during method creation
	 * (declaration)
	 * 
	 * parameters add: a, b
	 */
	public static int add(int a, int b) {
		int sum = a + b;
		
		Dog d = new Dog();
		d.bark();
		System.out.println(d.value);
		Dog two = new Dog();
		two.value
		
		/*
		 * the return keyword allows you to use
		 * the method as you would as expression
		 * b y using the value immediately to the left of the keyword
		 *  
		 * the return
		 */
		return sum;
		
	}

}
