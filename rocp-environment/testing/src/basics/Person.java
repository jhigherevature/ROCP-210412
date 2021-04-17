// Exercise: 1-3 //

// Description: Create a class called "Person" that declares name and address fields as Strings, an Id field as a long, and an age field as an int. //

// Confusion: giving the person proper data type value. Edited my original way out. Then I declared name as a long and I am not sure why it is not working. //

package basics;

public class Person {
	
	public static void main(String args[]) {
		
		// here is the problem. How do I give this data type characteristics? //
		//Pers pers = new Pers();
		
		// just used a string rather than a long so it would work //
		String persname;
		int persage;
		
		persname = "Benjamin";
		persage = 23;
		
		System.out.println("Name:" + persname);
		System.out.println("Age:" + persage);
		
	}
}
