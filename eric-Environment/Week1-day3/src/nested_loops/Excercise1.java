package nested_loops;

public class Excercise1 {
	
	public static void main(String[] args) {
			
		String top = "```";
		String stars = "*";
		String bot = "```";
		
		for (int x = 1; x < 2; x++) {
			
			System.out.println(top);
			
			for (int y = 1; y < 6; y++) {
				
				System.out.println(stars);
				stars = stars.concat("*");
					
				}
			
			System.out.println (bot);
				
			}
			
		}
		
	}

