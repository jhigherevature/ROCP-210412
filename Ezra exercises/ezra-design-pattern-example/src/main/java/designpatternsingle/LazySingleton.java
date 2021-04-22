package designpatternsingle;

/*
 * We have named this class 'Lazy' because it uses
 * a lazy instantiation method. Lazy instatiation means
 * that we only create the object when it is needed, not
 * before.
 */
public class LazySingleton {
	private int value;
	
	// reference to an instace of the singleton object
	private static LazySingleton mySingleton;
	
	/*
	 * This is our private constructor. By making this
	 * constructor private, we prevent any other class
	 * from creating instances (objects) of this class
	 * directly.
	 */
	private LazySingleton() { }
	
	
	public static LazySingleton getSingleton() {
		if (mySingleton == null) {
			mySingleton = new LazySingleton();
			return mySingleton;
		} else {
			return mySingleton;
		}
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

