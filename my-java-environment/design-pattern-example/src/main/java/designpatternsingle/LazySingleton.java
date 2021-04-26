package designpatternsingle;

/*
 * 
 * W
 */
public class LazySingleton {
	private int value;
	
	// reference to an instance of the singleton object
	private static LazySingleton mySingleton;
	
	/* 
	 * This is our private constructor. By making this
	 * constructor private, we prevent any other class
	 * from creating instance (objects) of this class
	 * directly.
	 */
	private LazySingleton() {}
	
	public static LazySingleton getSingleton() {
		if (mySingleton == null) {
			mySingleton = new LazySingleton();
			return mySingleton;
		}
		else {
			return mySingleton;
		}
	}
	
	public int getValue() {
		return this.value;
	}
	public void setValue() {
		this.value = value;
	}
	/*
	 * Here we override the clone method from the Object
	 * class to prevent users from creating new objects
	 * using the clone method on our singleton, which would
	 * contradict our singleton design patter.
	 */
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
		
	}
	
	public static void main(String[] args) {
		// errror due to private constructor
		// LazySingleton ls = new LazySingleton();
				
				
		LazySingleton lazy1 = LazySingleton.getSingleton();
		LazySingleton lazy2 = LazySingleton.getSingleton();
				
		System.out.println(lazy1==lazy2);
	}
}
