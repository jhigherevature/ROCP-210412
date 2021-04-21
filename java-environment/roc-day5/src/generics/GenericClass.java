package generics;

/*
 * Generics provide a method for specifying a datatype
 * used for a class, at a later point in time (when you
 * create the objects)
 */
public class GenericClass <T> {
	private T info;
	
	public GenericClass (T info) {
		this.info = info;
	}
	
	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}

	public String toString() {
		return "GenericClass [info=" + info + "]";
	}	
}
