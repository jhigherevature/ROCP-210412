package designpatternsingle;

/*
 * The Singleton design patters is achieved by creating
 * a class with a method that will create an instance of
 * an object ONLY when one does not already exist. 
 * Otherwise, the class will return a reference to the 
 * already existing object.
 * 
 * There are a few ways we can implement the singleton
 * design pattern; however a common trait for this 
 * pattern is to establish a private constructor and
 * an overridden clone method (from the Object class)
 */
public class SingletonSimulator {
	public static void main(String[] args) {
		// error due to private constructor
//		LazySingleton ls = new LazySingleton();
		
		LazySingleton lazy1 = LazySingleton.getSingleton();
		LazySingleton lazy2 = LazySingleton.getSingleton();
		System.out.println("Lazy Singleton: ");
		System.out.println(lazy1 == lazy2);
		
		EagerSingleton eager1 = EagerSingleton.getSingleton();
		EagerSingleton eager2 = EagerSingleton.getSingleton();
		System.out.println("Eager Singleton: ");
		System.out.println(eager1 == eager2);
	}
}
