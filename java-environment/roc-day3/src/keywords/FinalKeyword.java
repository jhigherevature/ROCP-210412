package keywords;

public class FinalKeyword {
	public final int number = 20;
	
	public final void doSomething() {
//		number = 99; // error
		System.out.println("This did something");
	}
	
	public void nonFinal() {
		System.out.println("This was non-final");
	}
}
