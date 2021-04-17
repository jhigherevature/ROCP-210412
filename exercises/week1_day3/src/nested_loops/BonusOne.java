package nested_loops;

public class BonusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char letter = 'A';
		int index = 1;
		
		while(letter <= 'Z')
		{
			while(index <= 26)
			{
				System.out.println(letter + " - " + index);
				letter++;
				index++;
				break;
			}
		}
		
		System.out.println();
		System.out.println();
		BonusOne bonusOne = new BonusOne();
		bonusOne.skipVowels();
	}
	
	public void skipVowels()
	{
		char letter = 'A';
		int index = 1;
		
		while(letter <= 'Z')
		{
			while(index <= 26)
			{
				if(letter == 'A' || letter == 'E' || letter == 'I' ||
						letter == 'O' || letter == 'U')
				{
					letter++;
					index++;
					continue;
				}
				System.out.println(letter + " - " + index);
				letter++;
				index++;
				break;
			}
		}
	}
	
}