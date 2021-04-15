package nestedLoops;

public class Exercise1 {
	
	public static void main(String[] args) {
		
		
		for (int row = 1; row < 6; row++) {
			
			for (int amount = 0; amount < row; amount++) {
				System.out.print("*");
			} 
			
			System.out.println("");
		}
		
		
	}
	
}