package generics;

public class GenericSimulator {
	public static void main(String[] args) {
		/*
		 * Note that we do not require the generic type
		 * to be declared on the Variable datatype or
		 * on the Constructor.
		 * 
		 * If a generic type is not provided on both
		 * than 'Object' type is used implicitly
		 */
		GenericClass intGc = new GenericClass<Integer> (15);
		GenericClass<String> strGc = new GenericClass ("Hello");
		
		System.out.println(intGc);
		System.out.println(strGc);
	}
}
