package methods_with_parameters;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Simulator {
	public static void main(String[] args) {
		float[] array = ExerciseOne._square_(1,2,3,4);
		System.out.println(Arrays.toString(array));
		System.out.println(BonusOne.findFirstWord("test","abcd"));
		int[] a = {1,2,3,4,5};
		int[] b = {3,4,5,3,2};
		BonusTwo.displayArrayStatistics(a,b);
	}
}
