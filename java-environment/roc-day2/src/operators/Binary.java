package operators;

public class Binary {
	public static void main(String[] args) {
		int x = 5;
		int y = 5;
		System.out.println(x * y);
		System.out.println(x / y); // Decimal is truncated if int
		System.out.println(x % y);
		System.out.println(x + y);
		System.out.println(x - y);
		
		System.out.println(x > y);
		System.out.println(x < y);
		System.out.println(x >= y);
		System.out.println(x <= y);
		System.out.println(x > x);
		System.out.println(x >= x);
		System.out.println(x <= x);
		System.out.println(x == y);
		System.out.println(x != y);
	}
}
