package gathering_user_input;

import java.util.Scanner;

public class ExerciseOne {

	static Scanner console = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("Enter a senetence.");
		String str = console.nextLine();
		str = str.toLowerCase();
		String result = "";
		
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || 
					str.charAt(i) == 'o' || str.charAt(i) == 'u')
			{
				 result = result + "" + str.charAt(i);
			}
		}
		System.out.println(result);
		console.close();
	}
}