package forloop;

public class ForLoops {
/* 
 * using a for loop, print odd numbers from 100 to 0 in descending order
 *  
 */
	public static void main(String[] args) {
		int n = 1;
        int i = 100;
		for (n < i; i--) {
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
}
}