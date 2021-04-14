
public class whileLoop {
	public static void main(String[] args) {
/*
 * # Exercise 1
For this exercise, you need to write a while
loop that prints the numbers 1 through 10, 
inclusively each on a separate line.

**HINT**: You can use a variable 
*that you increase during each iteration (step) 
*of the loop. You can also use an if-statement 
*to determine when to exit the loop.
 */
		
		int i = 1;
		while(i<=10) {System.out.println(i); i++;}
/*
 * # Exercise 2
For this exercise, you must write a 
while loop that prints all of the 
even numbers 100 to -100, inclusively, 
each on a separate line.
 */
		 i = 100;
		while(i>=-100) {System.out.println(i); i+=-2;}

	}
}
