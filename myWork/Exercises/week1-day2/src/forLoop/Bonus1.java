package forLoop;

public class Bonus1 {
	
	public static void main(String[] args) {
		
		for (int x = 100; x > 0; x--) {
			if (x % 2 == 0) {
				continue;
				
			}
			System.out.println(x);
		} 
		
	}

}
