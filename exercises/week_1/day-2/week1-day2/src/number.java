/*# Exercise 2
For this exercise Create an executable class 
(a class with a main method). 
Within the main method create an integer variable
called "number" and initialize it to any 
int value.

Create an if statement below this 
variable that checks if the value is 
even or odd. If the number is even, 
print "Even value" to the console. 
If the number is false, print "False value" 
instead.
*/

public class number{
	
	public static void main(String[] args) {
		int number = (int)(Math.random()*100);
		if(number % 2 == 0) {System.out.println("Even value " + number);}
		if(number % 2 != 0) {System.out.println("False value " + number);}
		}
		
	}

