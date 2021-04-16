package iteration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetSimulator {
	public static void main(String[] args) {
		System.out.println("::: SETS :::");
		Set<String> hSet = new HashSet<String> ();
		hSet.add("Assembly");
		hSet.add("Binary");
		hSet.add("Compile");
		hSet.add("Compile");
		hSet.add("Compile");
		hSet.add("DataStructure");
		hSet.add("Function");
		
		System.out.println("Set - Enhanced For-Loop");
		for (String name : hSet) {
			System.out.println(name);
		}
		/*
		 * Note: Iterators for many data structures
		 * (including hashSets) do not guarantee the 
		 * order of traversal.
		 */
		System.out.println("Set - While Loop");
		Iterator<String> setItr = hSet.iterator();
		while (setItr.hasNext()) {
			System.out.println(setItr.next());
		}
	}
}
