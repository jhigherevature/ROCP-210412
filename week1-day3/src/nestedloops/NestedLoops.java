package nestedloops;

public class NestedLoops {
	
		public static void main(String[] args) {
        String stars = "";
		for (int i = 0; i <= 6; i++) {
            for (int j = 1; j > i; j++) {
            	stars += "*";
            	System.out.println(stars);
        }
		}		
	}			
			
}