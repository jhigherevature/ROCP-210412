package basics;

public class Casting {
	/*
	 * When casting, Java will implicitly
	 * upcast (convert from smaller to larger)
	 * but you must explicitly downcast (convert 
	 * from larger to smaller) 
	 */
	public static void main(String[] args) {
		
		int num = 65;
		double decimal = num;
		
		double decimal_2 = 65.0;
		int num_2 = (int)decimal_2;
		
		char letter = (char)num;
		System.out.println(letter);
		
		/*
		 * When converting between datatypes
		 * the binary values are truncated
		 * which can lead to strange representations
		 * for numbers
		 */
		byte b = (byte)3255; // -73
		System.out.println(b);
	}
}
