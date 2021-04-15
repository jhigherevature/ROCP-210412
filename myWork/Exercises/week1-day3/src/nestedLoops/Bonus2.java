package nestedLoops;

public class Bonus2 {
	
	public static void main(String[] args) {
		
		String[] firstNames = {"Adam", "Alexis", "Dennis", "Jessica", "Meghan", "Memphis", "Nicky", "Sarah", "William"};
		String[] lastNames = {"Adamson", "Bond", "Brown", "Johnson", "Gallagher", "Smith", "Thompson", "Perez", "Snow", "Tran"};
		
		for (int firstIndex = 0; firstIndex < firstNames.length; firstIndex++) {
			
			for (int lastIndex = 0; lastIndex < lastNames.length; lastIndex++) {
				
				System.out.println(firstNames[firstIndex] + " " + lastNames[lastIndex]);
				
			}
			
		}
		
	}

}
