package methodsWithParameters;

import java.util.Map;
import java.util.HashMap;

public class Exercise1 {
	
	public static void main(String[] args) {
		
		for (float index : squareV2(67, 8, 18, 10)) {
			
			System.out.println(index);
		}
		
		System.out.println(findFirstWord("melon", "cake", "bee"));
			
	}
		
	public static float[] squareV1(int w, int x, int y, int z) {
		
		w *= w;
		x *= x;
		y *= y;
		z *= z;
		
		float[] squaredValues = {w, x, y, z};
		
		return squaredValues;
		
	}
	//The spicy one!!
	public static float[] squareV2(float... numbers) {
		
		for (int index = 0; index < numbers.length; index++) {
			
			numbers[index] *= numbers[index];
		}
		return numbers;
	}
	
	public static String findFirstWord(String... words) {
		
		// set return variable
		String firstWord = words[0];
		// make map to hold data to be analyzed
		Map<String, char[]> letterMap = new HashMap<>();
		
		//populate map with data from parameters
		for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
			
			//build  letter array with current word length
			char[] letterArray = new char[words[wordIndex].length()];
				//populate letter array	
				for (int letterIndex = 0; letterIndex < words[wordIndex].length(); letterIndex++) {
				
					letterArray[letterIndex] = words[wordIndex].charAt(letterIndex);
				
				
				}
			// set map keys and values	
			for (int mapIndex = 0; mapIndex < words.length; mapIndex++) {
				
				letterMap.put(words[wordIndex], letterArray);
				
			}
		
		}
		//analyze map data
		
			
		}
	
		return firstWord;
	
	}

}
