package operators;

public class Unary {
	public static void main(String[]args) {
		int post = 10;
		int pre = 10;
		
		System.out.println(post); //10
		System.out.println(post++); //10
		System.out.println(post); //11
		
		System.out.println(pre); //10
		System.out.println(++pre); //11
		System.out.println(pre); //11
		
		System.out.println(true);
		System.out.println(false);
	}
}
