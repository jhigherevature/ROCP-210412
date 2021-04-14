package dowhile;

public class PrintOddNumbers {
/*
 *   using a do-while loop, print odd numbers from 1 to 49 
 *   on a separate line
 */
	public static void main(String[] args) {
		int i = 1;
	    do {
	    	if (i%2==1) {
	    		System.out.println(i);
	    	}
	    	i++;
	    	}
	    while (i<50);
	}
    }

