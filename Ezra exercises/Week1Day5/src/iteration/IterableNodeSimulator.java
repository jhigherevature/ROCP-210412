package iteration;

import java.util.Iterator;

import collections.Node;

public class IterableNodeSimulator {
	public static void main(String[] args) {
		System.out.println("::: IterableNodeStack :::");
		IterableNodeStack ins = new IterableNodeStack();
		ins.push(4);
		ins.push(5);
		ins.push(2);
		ins.push(7);
		ins.push(6);
		
		System.out.println("Enhanced - For Loop");
		for (Node n : ins)
			System.out.println(n);
		
		System.out.println("For Loop");
		for (Iterator<Node> iter = ins.iterator(); iter.hasNext(); )
			System.out.println(iter.next());
		
		System.out.println("While Loop");
		Iterator<Node> insIter = ins.iterator();
		while (insIter.hasNext())
			System.out.println(insIter.next());
		
	}
}
