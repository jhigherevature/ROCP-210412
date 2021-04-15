package operators;

public class AlphabetArray {
	public char[] getAlphabetArray() {
		char [] abcArray = new {26};
		
//		for loop attempt ---given up...for now
		for (char i = 'a'; i <= 'z'; i++) {
			int c=0;
			abcArray[c]= i;
			System.out.println(abcArray[c]);
			c++;
			}
		
		
		return abcArray[];
			
	}
		
}
//abcArray[0]='a';
//int arr =0;
//char let = 'a';
////doesn't work...not sure why
//while (let != 'z') {
//	abcArray[arr]=let;
//	System.out.println(abcArray[arr]);
//	arr++;
//	let++;
//} 

// Write a method that returns an array of characters that represents the letters of the alphabet from `a` to `z`. You can name the method `getAlphabetArray`.

//**Bonus**
//If you have not already done so, utilize a for-loop to create the array of character values within this method.