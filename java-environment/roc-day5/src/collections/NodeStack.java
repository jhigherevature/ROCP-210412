package collections;

public class NodeStack {
	/*
	 * Reference to the last node added to the stack
	 */
	private Node top;
	
	/*
	 * The push method allows us to add a node to the 
	 * top of our stack
	 */
	public void push(int element) {
		Node node = new Node(element);
		push(node);
	}
	
	// Overloaded push method
	public void push(Node node) {
		node.setNext(top);
		this.top = (node);
	}
	
	/*
	 * The pop method allows us to remove the topmost 
	 * node from the stack, and return it
	 */
	public Node pop() {
		Node poppedNode = top;
		top = top.getNext();
		poppedNode.setNext(null);
		return poppedNode;
	}

	// The peek method is used to view the current 'top' node
	public Node peek() {
		return top;
	}
}
