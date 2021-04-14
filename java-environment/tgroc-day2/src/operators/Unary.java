package operators;

public class Unary {
	
	public static void main(String[] args) {
		int post = 10;
		int pre =  10;
		System.out.println(post);
		System.out.println(post++);
		System.out.println(post);
		
		System.out.println(pre);
		System.out.println(++pre);
		System.out.println(pre);
		
		System.out.println(!true); //false
		System.out.println(!false); //true
	}

}
