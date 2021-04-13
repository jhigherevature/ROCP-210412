	/*
	 * Create a class called "Datatypes". Within a main method in 
	 * this class, declare and initialize variables of type byte, 
	 * short, char, int, long, float, double, boolean, and print 
	 * each variable to the console.
	 * 
	 * Note: Remember that long values must be proceeded by the 
	 * letter 'L', and float values must be proceeded by the letter 
	 * 'F'. Additionally, character values must be within single 
	 * quotation marks.
	 */
package basics;

public class Datatypes {
	public static void main(String[] args)
	{
		
		byte num1 = 65; // whole number 8 bits
		short num2 = 5982;	// whole number 16 bits
		char num3 = 'x'; // alpha characters using single quotes
		int num4 = 999_123; // whole number 32 bits
		long num5 = 965_152_154l; // whole number 64 bits, uses lowecase letter 'L' to denote long 
		float num6 = 985_247_526.24f; // decimal point value 32 bits, uses lowercase letter 'F' to denote float
		double num7 = 987_415_368.54; // decimal point value 64 bits
		boolean num8 = false; // either true or false - keyword

		System.out.println("The byte is " + num1);
		System.out.println("The short is " + num2);
		System.out.println("The char is " + num3);
		System.out.println("The int is " + num4);
		System.out.println("The long is " + num5);
		System.out.println("The float is " + num6);
		System.out.println("The double is " + num7);
		System.out.println("The boolean is " + num8);
	}
}
