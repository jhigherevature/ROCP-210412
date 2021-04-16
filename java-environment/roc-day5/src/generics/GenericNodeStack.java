package generics;

public class GenericNodeStack<T> {
	GenericNode<T> top;
	
	public void push(GenericNode<T> node) {
		node.setNext(top);
		this.top = node;
	}
	
	public void push(T data) {
		GenericNode<T> temp = new GenericNode<T>(data);
		push(temp);
	}
	
	public GenericNode<T> pop() {
		GenericNode<T> popped = top;
		top = top.getNext();

		popped.setNext(null);		
		return popped;
	}

	public GenericNode<T> peek() {
		return top;
	}
}
