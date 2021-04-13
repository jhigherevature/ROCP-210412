package operators;
class Example {
	String name = "Shannon";
}


public class EqualTo {
	
	public static void main(String[] args) {
		Example one = new Example();
		Example two = new Example();
		Example three = one;
		System.out.println("one == two     " + (one == two));
		System.out.println("one == three   " + (one == three));

	}
}
