package methods;

public class Simulator {

	public static void main(String[] args) {
		System.out.println(add(5,10));
		System.out.println(add(20,15));
		System.out.println(add(500,1000));
		
		Dog d = new Dog("chuck",4, "Lab");
		d.bark();
		System.out.println(d.value);
		Dog.bark();
		
		Dog two = new Dog("pugde", 7, "pitbull");
		two.value = 100;
		System.out.println(d.value);
		System.out.println(two.value);
		
		System.out.println(d == two);
		
	}
	
	/*
	 * arguments are the values that we give to our
	 * methods, when we invoke them.
	 * 
	 * parameters are the place-holders for data we can give to 
	 * our methods.
	 * 
	 * parameters are the ist we declare, during method
	 * creation(declaration)
	 * 
	 * parameters add: a, b
	 */
	public static int add(int a, int b) {
		int sum = a + b;
		System.out.println("The sum was: " + sum);
		return sum;
	}

}
