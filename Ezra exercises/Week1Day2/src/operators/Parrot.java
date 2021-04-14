package operators;

public class Parrot {
	
	
	
	String name = "Polly";
	public String talk(String name) {
		this.name = name;
		System.out.println(this.name + " wants a cracker!");
		return (name + " wants a cracker!");
	}
}

// Create a class called "Parrot" which has a String field called "name". Initialize this name property to any String value.

//Create a method within this parrot class called "Talk" which prints the name property of the object followed by " wants a cracker!".

