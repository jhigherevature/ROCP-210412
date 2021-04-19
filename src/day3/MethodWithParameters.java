package day3;

public class MethodWithParameters {
	
	public static void main(String[]args) {
		String result = findFirstWord("Hello", "World");
		System.out.print(result);
	}

	public static String findFirstWord(String firstParameter, String secondParameter) {
		
		String firstWord = "";
		
		if(firstParameter.compareTo(secondParameter) < 1)
			firstWord = firstParameter;
		else
			 firstWord = secondParameter;
		
		return firstWord;
	}
}
