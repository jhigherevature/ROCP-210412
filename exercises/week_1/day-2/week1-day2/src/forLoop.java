/*
 * # Exercise 1

Create an array of ten `byte` values.
The values can be any arbitrary numbers 
that you choose. Now use a `for` loop 
to iterate over the elements in the array 
and print them to the console. 
 */
public class forLoop {
	public static void main(String[] args) {
		
		byte[] b = {1,2,3,4,5,6,7,8,9,10};
		for(int i = 0; i < b.length; i++ ) 
		{System.out.println(b[i]);}
		
/*
* # Bonus 1
Create a for-loop that prints 
odd numbers from 100 to 0 in descending order.
*/
		for(int j = 99; j >=0 ; j-=2) 
		{System.out.println(j);}

	}
}
