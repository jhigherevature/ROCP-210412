package operators;

public class ForBonus {
	
	public static void main(String[] args) {
		printOdd();
		
	
	}
	public static void printOdd() {
		for (int count = 0; count == 100; ++count) {
			if (count % 2 == 1) {
				System.out.println(count);
				}
//			else {continue;}
		}
	}
}

//Create a for-loop that prints odd numbers from 100 to 0 in descending order.