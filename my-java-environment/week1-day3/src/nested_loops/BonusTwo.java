package nested_loops;

public class BonusTwo {
	public static void main(String[] args) {
		String[] firstName = {"Adam", "Alexis", "Dennis", "Jose", "Jessica", "Meghan", "Memphis", "Nicky", "Sarah", "William"};
		String[] lastName = {"Adamson", "Bond", "Brown", "Johnson", "Gallagher", "Smith", "Thompson", "Perez", "Snow", "Tran"};
		for (int i = 0; i < firstName.length; i++) {
			
			for (int k = 0; k < lastName.length; k++) {
				
				System.out.println(firstName[i] + " " + lastName[k]);
			}
		}
	}
}
