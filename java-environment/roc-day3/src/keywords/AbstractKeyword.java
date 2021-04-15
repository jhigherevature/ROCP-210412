package keywords;

public abstract class AbstractKeyword {
	
	// abstract classes can contain non-abstract methods
	public void speak() {
		System.out.println("Hello");
	}
	
	/*
	 * The abstract keyword on a method does not
	 * require a method body
	 * 
	 * abstract methods can only exist in an abstract
	 * class.
	 */
	public abstract void eat();
	
}
