
public class methodsWithReturnTypes {
/*
 * # Exercise 1

Write a method that returns an array of characters 
that represents the letters of the alphabet from 
`a` to `z`. You can name the method `getAlphabetArray`.

**Bonus**
If you have not already done so, utilize 
a for-loop to create the array of character 
values within this method.

 */

	public static char[] getAlphabetArray() {
		char AlphabetIndex = 'a';
		char[] getAlphabetArray = new char[26] ;
		
			for(int i = 0; i <26;i++) {
				getAlphabetArray[i]= AlphabetIndex;
				AlphabetIndex++;
			}
			
		return getAlphabetArray;
	}
	
/*
 * # Bonus 1

Create a method named `getPi` that returns the value of pi.

**HINT**: You can use the Math class to get the value of pi.

```java
double d = Math.PI;
 */
	public static double getPi() {
		 double pi = Math.PI;
		return pi;
	}

	
	public static void main(String[] args) {
				
		char[] abc = getAlphabetArray();
		for(int i = 0; i <26;i++) {System.out.println(abc[i]);}
		
		double Pi = getPi();
		
		System.out.println(Pi);
				
	}

}
