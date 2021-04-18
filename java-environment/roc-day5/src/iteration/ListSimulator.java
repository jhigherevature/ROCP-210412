package iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSimulator {
	
	public static String firstLetter(String... words) {
		/*
		 * words:
		 * [ "assembly", "binary", "compile" ]
		 */
		if (words[0].charAt(0) == words[1].charAt(0)) {
			//do stuff...
		}
		return "";
	}
	
	public static void main(String[] args) {
		System.out.println("::: LISTS :::");
		List<String> alist = new ArrayList<String>();
		alist.add("Assembly");
		alist.add("Binary");
		alist.add("Compile");
		alist.add("Compile");
		alist.add("Compile");
		alist.add("DataStructure");
		alist.add("Functions");
		
		alist.remove("Assembly");
		
		System.out.println("List - Enhanced For-Loop");
		for (String name : alist) {
			System.out.println(name);
		}
		
		// Iterator - For Loop
		System.out.println("List - For Loop");
		for (Iterator<String> i = alist.iterator(); i.hasNext(); ) {
			String name = i.next();
			System.out.println(name);
		}

		System.out.println("List - While Loop");
		Iterator<String> aItr = alist.iterator();
		while (aItr.hasNext()) {
			System.out.println(aItr.next());
		}
	}
}
