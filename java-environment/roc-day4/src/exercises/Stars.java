package exercises;

public class Stars {

	public static void main(String[] args) {
		
		outer: for (int i = 0; i <= 6; i++) {
			if (i == 0 || i == 6) {
				System.out.println("```");
				continue outer;
			}
			
			String stars = "";
			/* 
			 * This will loop a number of times equal
			 * to the outer loop cycle.
			 */
			inner: for (int j = 0; j < i; j++) {
				stars += "*";
			}
			
			System.out.println(stars);
		}
	}

}
