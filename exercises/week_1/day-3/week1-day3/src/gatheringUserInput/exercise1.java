package gatheringUserInput;

import java.util.Scanner;

/*
 * # Exercise One

Create a method that uses a Scanner to parse any input from the console 
(System.in) and prints out the number of vowels in the line.

**Note**: When you create a scanner that reads from System.in, 
*it relies on the fact that this input stream is by default open. 
*If you close your Scanner that reads from System.in, then the 
*System.in input stream will be closed for the rest of the program. 
*This will cause you trouble if you go to create 
*a new Scanner that uses System.in within the same program.

A simple work around is to create a single Scanner object as a static field. 
Then use the same scanner in all of your methods. 
Finally, close this Scanner object at the end of the main method. 
Just before your program finishes. 
(This will be needed if you try to have 
both Exercise One and Two in the same class.) 
 */

public class exercise1 {
	
	

	public static void main(String[] args) {
		
		char[] Vowels = {'a','e','i','o','u','A','E','I','O','U'};
		int numberOfVowels = 0;
		System.out.println("Type in one word, when you are done press enter.");
		Scanner scan = new Scanner(System.in);//get input
		String text = scan.next();//stor input
		char[] convertedInput = text.toCharArray(); // convert the String into an array of charecters
			for(int i =0; i <text.length(); i++) {//this outer loop increments the input string
				for(int j = 0; j <Vowels.length; j++) {//this inner loop increments the vowels 
					if(convertedInput[i]==Vowels[j]) {///if the character of the string is a vowel...
						numberOfVowels++;// increment vowel counter
					}
				}
				
			}
		
		System.out.println("There are " + numberOfVowels + " Vowels in the word you just typed.");
		scan.close();
	}
}
