package nested_loops;

public class ExerciseOne {
	public static void main(String[] args) {
		
		for (int lineCount = 1; lineCount <= 5; lineCount++) {
			
			for (int charCount = 1; charCount <= lineCount; charCount++) {
				System.out.print("*");
			}
			
			System.out.print("\n");
		}
			
	}
}
