package methods_with_return_types;

public class ExerciseOne {
	
	public static char[] getAlphabetArray()
	{
		char[] letters = new char[26];
		int j = 97;
		for(int i = 0; i < letters.length; i++)
		{
			letters[i] = (char)j;
			j++;
		}
		return letters;
	}
	
	public static void main(String[] args)
	{
		char[] array = getAlphabetArray();
		
		for(int i = 0; i < array.length; i++)
		{
			System.out.println(array[i]);
		}
	}
}