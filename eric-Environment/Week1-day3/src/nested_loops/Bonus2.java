package nested_loops;

public class Bonus2 {

	public static void main(String[] args) {
		
		String[] first = {"Adam", "Alexis", "Dennis", "Jose", "Jessica", "Meghan", "Memphis", "Nicky", "Sarah", "William"};
		String[] second = {"Adamson", "Bond", "Brown", "Johnson", "Gallagher", "Smith", "Thompson", "Perez", "Snow", "Tran"};
		
		for (int x = 0; x < first.length; x ++) {
			
			for (int i = 0; i < second.length; i++) {
				
				System.out.println(first[x] + " " + second[i]);
				
			}
			
		}
		
	}

}
