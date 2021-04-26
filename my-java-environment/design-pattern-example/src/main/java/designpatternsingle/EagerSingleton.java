package designpatternsingle;

/*
 * We have named this class 'Eager' because it uses
 * an 'Eager' instantiation method. THis means that our
 * Singleton object is created when the class is loaded
 * into memory, and our singleton 
 */
public class EagerSingleton {


		private int value;
		
		// reference to an instance of the singleton object
		private static EagerSingleton mySingleton = new EagerSingleton();
		
		/* 
		 * This is our private constructor. By making this
		 * constructor private, we prevent any other class
		 * from creating instance (objects) of this class
		 * directly.
		 */
		private EagerSingleton() {}
		
		public static EagerSingleton getSingleton() {
			return mySingleton;
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
	
			EagerSingleton eager1 = EagerSingleton.getSingleton();
			EagerSingleton eager2 = EagerSingleton.getSingleton();
	
			System.out.println(eager1==eager2);
		}
}
		
	

	

	
		


	

