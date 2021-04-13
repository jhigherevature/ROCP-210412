package operators;


public class Binary {

	public static void main(String[] args) {
		int x = 5;
		int y = 2;
		int z = 5;
		
		System.out.println(x * y);
		System.out.println(x / y);  //decimal is truncated
		System.out.println(x % y);  //remainder
		System.out.println(x + y);
		System.out.println(x - y);
		System.out.println("\n");

		System.out.println(x > x);
		System.out.println(x > y);
		System.out.println(x < x);
		System.out.println(x < y);
		System.out.println(x >= z);
		System.out.println(x <= x);
		System.out.println("\n");

		System.out.println(x == 5);
		System.out.println(x == y);
		System.out.println(x != 5);
		System.out.println(x != y);
		System.out.println("\n");
		/*
		Examples ex_1 = new Example();
		Example ex_2 = new Example();
		Example ex_2 = ex_1;

		System.out.println("ex1 == ex2 " + (ex_1 == ex_2));
		System.out.println("ex1 == ex3 " + (ex_1 == ex_3));
		 */

				


	}

}
