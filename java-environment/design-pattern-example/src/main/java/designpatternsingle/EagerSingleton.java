package designpatternsingle;

/*
 * We have named this class 'Eager' because it uses
 * an 'Eager' instantiation method. This means that our
 * Singleton object is created when the class is loaded
 * into memory, and our singleton object is always
 * available in our application.
 */
public class EagerSingleton {
	private int value;
	
	// reference to an instance of the singleton object
	private static EagerSingleton mySingleton = new EagerSingleton();
	
	/*
	 * This is our private constructor. By making this
	 * constructor private, we prevent any other class
	 * from creating instances (objects) of this class
	 * directly.
	 */
	private EagerSingleton() { }
	
	
	public static EagerSingleton getSingleton() {
		return mySingleton;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	/*
	 * Here, we override the clone method from the Object
	 * class to prevent users from creating new objects
	 * using the clone method on our singleton, which would
	 * contradict our singleton design pattern.
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
