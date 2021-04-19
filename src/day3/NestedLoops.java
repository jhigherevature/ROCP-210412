package day3;

public class NestedLoops {

	public static void main(String[] args) {

		printStars();
		printAlphabetsAndPosition();
		printNameCombinations();
	}

	public static void printStars() {
		for (int row = 0; row < 5; row++) {
			for (int column = 0; column < row + 1; column++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}

	public static void printAlphabetsAndPosition() {

		for (int i = 0; i < 26; i++) {
			char alphabet = (char) (i + 65);
			System.out.println(alphabet + " - " + (i + 1));
		}
	}

	public static void printNameCombinations() {
		String[] firstNames = { "Adam", "Alexis", "Dennis", "Jose", "Jessica", "Meghan", "Memphis", "Nicky", "Sarah",
				"William" };

		String[] lastNames = { "Adamson", "Bond", "Brown", "Johnson", "Gallagher", "Smith", "Thompson", "Perez", "Snow",
				"Tran" };

		for (int firstIndex = 0; firstIndex < firstNames.length; firstIndex++) {
			for (int lastIndex = 0; lastIndex < lastNames.length; lastIndex++) {
				System.out.println(firstNames[firstIndex] + " " + lastNames[lastIndex]);
			}
		}
	}
}
