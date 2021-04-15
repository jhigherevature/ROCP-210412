package nestedLoops;

/*
 * # Exercise 1

Use nested for-loops to print the following:

```
*
**
***
****
*****
```

HINT: you can use `System.out.print` to print information on the same line, instead of `System.out.println` which prints to a new line.

			System.out.println("*");
			System.out.print("*");
			System.out.println("*");
			System.out.print("*");
			System.out.print("*");
			System.out.println("*");
			System.out.print("*");
			System.out.print("*");
			System.out.print("*");
			System.out.println("*");
			System.out.print("*");
			System.out.print("*");
			System.out.print("*");
			System.out.print("*");
			System.out.print("*");

 */

public class Exercise1 {
	
	public static void main(String[] args) {
		
			System.out.print("```");
			System.out.println();
			
				for(int i = 1; i <6; i++) {
					System.out.println("*");
					if(i == 5) {break;}
		
						for(int j = 0; j <i; j++) {
							System.out.print("*");
						}		
				}	
				
			System.out.print("```");
			System.out.println();
	}
	
}
