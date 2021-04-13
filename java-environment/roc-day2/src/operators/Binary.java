package operators;

public class Binary {

	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		
//		x += y;	// x set to 7
//		x -= y; // x set to 3
//		x *= y; // x set to 10
//		x /= y; // x set to 2
		
		System.out.println("* " + (x * y));
		System.out.println("/ " + (x / y)); // decimal is truncated
		System.out.println("% " + (x % y));
		System.out.println("+ " + (x + y));
		System.out.println("- " + (x - y));

		System.out.println("x > x " + (x > x));
		System.out.println("x > y " + (x > y));
		System.out.println("x < y " + (x < x));
		System.out.println("x < y " + (x < y));
		System.out.println("x >= x " + (x >= x));
		System.out.println("x <= x " + (x <= x));

		System.out.println("x == 5 " + (x == 5));
		System.out.println("x == y " + (x == y));
		System.out.println("x != 5 " + (x != 5));
		System.out.println("x != x " + (x != y));
		
		Example ex_1 = new Example();
		Example ex_2 = new Example();
		Example ex_3 = ex_1;
		
		System.out.println("ex1 == ex2 " + (ex_1 == ex_2));
		System.out.println("ex1 == ex3 " + (ex_1 == ex_3));
	}

}
