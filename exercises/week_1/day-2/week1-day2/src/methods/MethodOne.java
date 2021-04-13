package methods;

public class MethodOne {
	public static int randomNumber() {
		double d = Math.random();
		return (int) (d *50);
		
	}
	public static void main(String[] args) {
		System.out.println(randomNumber());
	}
}
