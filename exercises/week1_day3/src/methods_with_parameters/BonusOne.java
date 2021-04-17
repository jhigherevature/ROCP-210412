package methods_with_parameters;

public class BonusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(findFirstWord("Ate", "app"));
	}
	
	public static String findFirstWord(String firstWord, String secondWord)
	{
		/*
		 * Make sure that both words are all lowercase so that a capital 'A' and a 
		 * lowercase 'a' are treated as the same letter when comparing words.
		 */
		
		firstWord = firstWord.toLowerCase();
		secondWord = secondWord.toLowerCase();
		
		/*
		 * Both words are the same length so I am able to use either firstWord.length or 
		 * secondWord.length. I don't have to account for a case where one word is longer 
		 * than the other.
		 */
		
		for(int i = 0; i < firstWord.length(); i++)
		{
			if(firstWord.charAt(i) < secondWord.charAt(i))
			{
				return firstWord;
			}
			
			if(firstWord.charAt(i) > secondWord.charAt(i))
			{
				return secondWord;
			}
		}
		/*
		 * If we make it to this line of code below, then that means they are the same word,
		 * so return either word.
		 */
		return firstWord;
	}
}