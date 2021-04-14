package methods_with_return_types;

public class ExerciseOne {

	static char[] getAlphabetArray() {
		char aToZ[] = new char[26];
		char letter = 'a';
		for (int i = 0; i < 26; i++) {
			aToZ[i] = (char)(letter + i);
		}
		return aToZ;
	}
}
