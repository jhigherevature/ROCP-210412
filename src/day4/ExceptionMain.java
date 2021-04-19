package day4;

public class ExceptionMain {

	public static void main(String[] args) throws OddNumberException {
		addEven(2,3);

	}

	static void addEven(int a, int b) throws OddNumberException {
		if (a % 2 == 1 || b % 2 == 1)
			throw new OddNumberException();
	}
}
