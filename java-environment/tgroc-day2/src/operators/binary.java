package operators;

public class binary {
	
	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		int z = 5;
		
		// x += y; // x set to 7
		// x -= y; // set to 3
		// x *= y; // x set to 10
		// x /= y; // x set to 2
		
		System.out.println(x * y);
		System.out.println(x / y); // decimal is truncated
		System.out.println(x % y);
		System.out.println(x + y);
		System.out.println(x -y);
		
		System.out.println(x > z);
		System.out.println(x > y);
		System.out.println(x < z);
		System.out.println(x < y);
		System.out.println(x >= x);
		System.out.println(x <= x);
		
		System.out.println(x == 5);
		System.out.println(x == y);
		System.out.println(x !=5);
		System.out.println(x !=y);
		
		Example ex_1 = new Example();
		Example ex_2 = new Example();
		Example ex_3 ex_1;
		
	}

}
