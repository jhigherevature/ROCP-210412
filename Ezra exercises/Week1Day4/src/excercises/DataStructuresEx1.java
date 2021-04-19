package excercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DataStructuresEx1 {

	public static void main(String[] args) {
		
		List<String> Ref = new ArrayList<String>();
		Ref.add("Jaque");
		Ref.add("Alex");
		Ref.add("Carrie");
		Ref.add("Ignacio");
		Ref.add("Byron");
		Ref.add("Gordon");
		Ref.add("Hazel");
		Ref.add("Max");
		Ref.add("Stephanie");
		Ref.add("Dev");
		Ref.add("Eric");
		Ref.add("Faith");
	
		System.out.println(Ref.size());
		System.out.println("print list");
		for (Iterator<String> i = Ref.iterator(); i.hasNext(); ) {
			String name = i.next();
			System.out.println(name);
		}
	}

}


//create an executable class with a main method. 
//Within this main method declare a reference variable for a List Object 
//which accepts String values. Initialize this value to a new ArrayList 
//which accepts String values. 
//Use the add method to add the following names to the 
//collection: Jaque, Alex, Carrie, Ignacio, Byron, Gordon, Hazel, Max, Stephanie, Dev, Eric, Faith

//**Note**: Generics use the angle-bracket notation and accept a Custom or built-in class. I.e.:
//```java
//List<Integer> 