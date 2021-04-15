package nestedLoops;

public class Exercise1 {
	
	public static void main(String[] args) {
		
		int rows = 5;
		
		for (int identifyRow = 1; identifyRow <= rows; identifyRow++) {
			
			for (int amount = 1; amount <= identifyRow; amount++) {
				System.out.print("*");
			} 
			
			System.out.println("");
		}
		
		
	}
	
}