package userinputconversion;

import java.util.Scanner;

public class UserInputConversion {

	public static void main(String[] args) {
	    
		Scanner sc = new Scanner(System.in);
	    loop: while (true) {
	    	System.out.println("Select a conversion: ");
	    	System.out.println("1. Feet to Inches");
	    	System.out.println("2. Feet to yards");
	    	System.out.println("3. Feet to Miles");
	    	System.out.println("4. Meters to Miles");
	    	System.out.println("5. Quit");
	    	System.out.println("Enter selection: ");
	    
	    	int i=sc.nextInt();
		    
	    	switch (i) {
			    case 1:
			    break;
			    case 2:
				break;
			    case 3:
				break;
			    case 4:
				break;
			    case 5:
			    break loop;
				default:
				System.out.println("Try again. Acceptable input: 1,2,3,4,5");
				break;
			}
		    if (i == 1 || i == 2 || i == 3 || i == 4)
			    {
	 		   System.out.println("Enter a value to convert: ");
	           float j=sc.nextInt();
			
	           if (i == 1) 
	           {
	         	System.out.println(j + " feet = " + (j*12) + " inches");
	           }
	           else
	           {
	           if (i == 2) 
	           {
	           System.out.println(j + " feet = " + (j/3) + " yards");
	           }
	           else 
	           {
	           if (i == 3) 
	           {
	           System.out.println(j + " feet = " + (j/5280) + " miles");
	           }
	           else 
	           {
	           if (i == 4) 
	           {
	           System.out.println(j + " meters = " + (j/1609) + " miles");
	           }}}}}
		}
}
}
// 			sc.close();

 


