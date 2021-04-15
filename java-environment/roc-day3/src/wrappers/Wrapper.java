package wrappers;

public class Wrapper {
	public static void main (String... args) {
		int num = 100;
		/*
		 * Autoboxing is the implicit process of
		 * converting from a primitive datatype
		 * into a Wrapper class equivalent
		 */
		Integer number = num;
		
		
		Integer number_2 = 100;
		/*
		 * Unboxing is the implicit process of
		 * converting from a wrapper class into
		 * a primitive datatype equivalent
		 */
		int num_2 = number_2;
		
		number_2.equals(number);
//		num_2.equals(num); // error
		
		Double dbl = 15.5;
		Boolean bool = true;
		
		Object[] numbers = new Object[] {number, number_2, dbl, bool};
	}
}
