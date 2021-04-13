# Exercise 2

Create a class called "Datatypes". Within a main method in this class, declare and initialize variables of type byte, short, char, int, long, float, double, boolean, and print each variable to the console.

**Note: Remember that long values must be proceeded by the letter 'L', and float values must be proceeded by the letter 'F'. Additionally, character values must be within single quotation marks.

class DataTypes{
	public static void main (String[] args) {
		byte b = 100;
	    char c = 'F';
	    int i = 1;
	    boolean result = false;
	    double d = 1_000_000.65;
	    float f = 0.45f;
	    long cc = 4427_3500_1211_7800l;
	    short s = 1000;
		
	    System.out.println(b);
	    System.out.println(c);
	    System.out.println(i);
	    System.out.println(result);
	    System.out.println(d);
	    System.out.println(f);
	    System.out.println(cc);
	    System.out.println(s);
	}
