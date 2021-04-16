package collections;

public class Node {
	private Integer data;
	private Node next;

	public Node(Integer data) {
		this.data = data;
	}
	
	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
}
