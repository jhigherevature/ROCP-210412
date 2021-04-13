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

	byte b = 127; // whole number 8 bits
	short s = 12345;	// whole number 16 bits
	char c = 'c'; // alpha characters using single quotes
	int i = 1_000_000; // whole number 32 bits
	long l = 1_000_000_000l; // whole number 64 bits, uses lowecase letter 'L' to denote long 
	float f = 1_000_000_000.00f; // decimal point value 32 bits, uses lowercase letter 'F' to denote float
	double d = 1_000_000_000.00; // decimal point value 64 bits
	boolean bool = true; // either true or false - keyword

	
	public void bark() {
		System.out.println("Woof Woof");
	}
}
