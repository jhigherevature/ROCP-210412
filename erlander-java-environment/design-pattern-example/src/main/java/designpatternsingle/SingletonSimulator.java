package designpatternsingle;

public class SingletonSimulator {
	public static void main(String[] args) {
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
