package functionalinterfaces;

import java.util.ArrayList;
import java.util.List;

public class ForEachSimulator {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Abe");
		names.add("Barry");
		names.add("Chloe");
		
		// using lambdas
		names.forEach( name -> System.out.println(name) );
		
		// enhanced for-loop
		for (String n : names) {
			System.out.println(n);
		}
	}

}
