/*
 * # Exercise 1

For this exercise, you need to write a 
do-while loop that prints the odd numbers
 1 through 49, inclusively, each on a 
 separate line.
 */
public class doWhile {
	
	public static void main(String[] args) {
		
		int number = 1;
		do {System.out.println(number); number +=2;}
		while(number <=49);
		

/*
 * # Bonus 1
For this exercise, you must write 
a do-while loop that prints the 
letters of the alphabet. You must use a single
**char** variable that you manipulate to 
print to the console. 
(You shouldn't have 26 lines of code that 
each print a letter...)
 */
		int index = 1;
		char letter= 'a';
		do {System.out.println(letter); index ++; ;letter ++;}
		while(index <=26);
	}
	

}
