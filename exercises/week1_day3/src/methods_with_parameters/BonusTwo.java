package methods_with_parameters;

public class BonusTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {1,3,2};
		int[] b = {2,2,2};
		BonusTwo bt = new BonusTwo();
		bt.displayArrayStatistics(a, b);
		}
	
	public void displayArrayStatistics(int[] a, int[] b)
	{
		/*
		 * Should list which array contains more even numbers, which array contains more 
		 * data, and which array contains more values that are a multiples of 3
		 */
		
		int evenNumbersA = 0;
		int multiplesOf3A = 0;
		int evenNumbersB = 0;
		int multiplesOf3B = 0;
		
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] % 2 == 0)
			{
				evenNumbersA++;
			}
			
			if(a[i] % 3 == 0)
			{
				multiplesOf3A++;
			}
		}
		
		for(int i = 0; i < b.length; i++)
		{
			if(b[i] % 2 == 0)
			{
				evenNumbersB++;
			}
			
			if(b[i] % 3 == 0)
			{
				multiplesOf3B++;                                       
			}
		}
		
		System.out.println("Array Data");
		if(evenNumbersA > evenNumbersB)
		{
			System.out.println("Array A contains more even numbers.");
		}
		else if(evenNumbersA < evenNumbersB)
		{
			System.out.println("Array B contains more even numbers.");
		}
		else
		{
			System.out.println("Arrays A and B contain the same number of even numbers.");
		}
		
		if(a.length > b.length)
		{
			System.out.println("Array A contians more data.");
		}
		else if(a.length < b.length)
		{
			System.out.println("Array B contains more data.");
		}
		else
		{
			System.out.println("Arrays A and B contain the same amounbt of data.");
		}
		
		if(multiplesOf3A > multiplesOf3B)
		{
			System.out.println("Array A contains more multiples of 3.");
		}
		else if(multiplesOf3A < multiplesOf3B)
		{
			System.out.println("Array B contains more multiples of 3");
		}
		else
		{
			System.out.println("Arrays A and B contain the same number of multiples of 3.");
		}
	}
}