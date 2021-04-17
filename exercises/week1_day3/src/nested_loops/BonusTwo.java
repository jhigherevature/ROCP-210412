package nested_loops;

public class BonusTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		String[] firstNames = {"Adam", "Alexis", "Dennis", "Jose", "Jessica", "Meghan", "Memphis",
				"Nicky", "Sarah", "William"};
		String[] lastNames = {"Adamson", "Bond", "Brown", "Johnson", "Gallagher", "Smith", 
				"Thompson", "Perez", "Snow", "Tran"};
		
		for(int i = 0; i < firstNames.length; i++)
		{
			for(int j = 0; j < lastNames.length; j++)
			{
				System.out.println(firstNames[i] + " " + lastNames[j]);
			}
		}
	}
}
