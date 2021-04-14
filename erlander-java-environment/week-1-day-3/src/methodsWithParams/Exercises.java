package methodsWithParams;

public class Exercises {

	public static void main(String[] args) {
		float[] arr = square(2, 3, 4, 5);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("---------------------");
		
		System.out.println(findFirstWord("Two", "Three"));
		
		System.out.println("---------------------");
		
		int[] arr1 = {2, 4, 6, 7, 14, 15};
		int[] arr2 = {3, 6, 9, 10, 12};
		
		
		displayArrayStatistics(arr1, arr2);

	}

	// exercise
	public static float[] square(int a, int b, int c, int d) {
		float[] fArr = new float[4];

		fArr[0] = a * a;
		fArr[1] = b * b;
		fArr[2] = c * c;
		fArr[3] = d * d;

		return fArr;
	}

	// bonus 1
	public static String findFirstWord(String a, String b) {
		int i = 0;
		a = a.toLowerCase();
		b = b.toLowerCase();
		String firstWord = "";

		for (i = 0; i < a.length(); i++) {

			if (a.charAt(i) == b.charAt(i)) {
				continue;
			}
			firstWord = (a.charAt(i) < b.charAt(i)) ? a : b;
			break;
		}

		return firstWord;
	}

	// bonus 2
	public static void displayArrayStatistics(int[] a, int[] b) {
		int evenCount = 0;
		int evenMax = 0;
		char moreEvens = 'A';
		int threeCount = 0;
		int threeMax = 0;
		char moreThrees = 'A';
		
		
		for(int num : a) {
			if(num % 2 == 0) {
				evenCount++;
			}
			if(evenCount > evenMax) {
				evenMax = evenCount;
			}
			
			if(num % 3 == 0) {
				threeCount++;
			}
			if(threeCount > threeMax) {
				threeMax = threeCount;
			}
		}
		
		evenCount = 0;
		threeCount = 0;
		
		for(int num : b) {
			if(num % 2 == 0) {
				evenCount++;
			}
			if(evenCount > evenMax) {
				evenMax = evenCount;
				moreEvens = 'B';
			}
			
			if(num % 3 == 0) {
				threeCount++;
			}
			if(threeCount > threeMax) {
				threeMax = threeCount;
				moreThrees = 'B';
			}
		}
		
		if(a.length != b.length) {
			char moreData = (a.length > b.length) ? 'A' : 'B';
			System.out.println(moreData + " has more data.");
		}
		
		System.out.println(moreEvens + " has more even numbers.");
		System.out.println(moreThrees + " has more multiples of three.");
		
		
	}
}
