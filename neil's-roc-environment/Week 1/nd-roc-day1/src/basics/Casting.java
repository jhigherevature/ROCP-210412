package basics;

public class Casting {
	/*
	 * When casting, Java will implicitly upcast(convert from smaller to larger)
	 */
	public static void main(String[]args) {
		int num = 65;
		@SuppressWarnings("unused")
		double decimal = num;
		
		double decimal_2 = 65.0;
		@SuppressWarnings("unused")
		int num_2 = (int)decimal_2;
		
		char letter = (char)num;
		System.out.println(letter);
		
		
	}
}
