package conditional_statements;

public class ExerciseTwo {
	public static void main(String[] args) {
		int value = 124;
		number(value);
	}
	static void number(int test) {
		if (test % 2 == 0) {
			System.out.println("Even value");
		}
		else {
			System.out.println("False value");
		}
	}
}
