package keywords;

public class Child extends FinalKeyword {
	
//	public void doSomething() { // error
//		
//	}
	
//	public void nonFinal() {
//		System.out.println("This is the new functionality!");
//	}
	
	public static void main(String[] args) {
		Child c = new Child();
		c.nonFinal();
	}
}
