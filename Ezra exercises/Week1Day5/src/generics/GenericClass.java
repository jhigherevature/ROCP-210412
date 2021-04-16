package generics;

public class GenericClass<Type> {
	private Type info;
	
	public GenericClass (Type info) {
		this.info = info;
	}
	
	public Type getInfo() {
		return info;
	}
	
	public void setInfo(Type info) {
		this.info = info;
	}

	public String toString() {
		return "GenericClass [info=" + info + "]";
	}	
}
