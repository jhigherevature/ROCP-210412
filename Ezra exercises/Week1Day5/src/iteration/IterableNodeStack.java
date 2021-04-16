package iteration;

import java.util.Iterator;
import collections.Node;

public class IterableNodeStack implements Iterable<Node> {

	private Node top;
	/*
	 * Used to track which node is 'next' 
	 * in the iterator
	 */
	private Node cursor;
	
	public void push(int element) {
		Node node = new Node(element);
		push(node);
	}
	
	public void push(Node node) {
		node.setNext(top);
		this.top = (node);
		this.cursor = top;
	}
	
	public Node pop() {
		Node poppedNode = top;
		top = top.getNext();
		poppedNode.setNext(null);
		return poppedNode;
	}

	public Node peek() {
		return top;
	}
	
	@Override
	public Iterator<Node> iterator() {
		return new NodeIterator();
	}
	
	private class NodeIterator implements Iterator<Node> {
		
		NodeIterator() {
			cursor = top;
		}
		
		@Override
		public boolean hasNext() {
			if (cursor != null)
				return true;
			
			return false;
		}

		@Override
		public Node next() {
			Node ret = cursor;
			if (cursor != null)
				cursor = ret.getNext();
			
			return ret;
		}		
	}
}


