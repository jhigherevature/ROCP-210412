package generics;

/*
 * Generics provide a method for specifying a datatype
 * used for a class, at a later point in time (when you
 * create the objects)
 */
public class GenericClass<Placeholder> {
	private Placeholder info;
	
	public GenericClass (Placeholder info) {
		this.info = info;
	}
	
	public Placeholder getInfo() {
		return info;
	}
	
	public void setInfo(Placeholder info) {
		this.info = info;
	}

	public String toString() {
		return "GenericClass [info=" + info + "]";
	}	
}
