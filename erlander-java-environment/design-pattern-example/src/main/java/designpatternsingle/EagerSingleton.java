package designpatternsingle;

public class EagerSingleton {
private int value;
	
	private static EagerSingleton mySingleton = new EagerSingleton();
	
	private EagerSingleton() {};
	
	public static EagerSingleton getSingleton() {
		return mySingleton;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}	
	
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		throw new CloneNotSupportedException();
	}
}
