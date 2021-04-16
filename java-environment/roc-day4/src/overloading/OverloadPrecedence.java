package overloading;

public class OverloadPrecedence {

	public static void main(String[] args) {		
		method(5);
		method((short)5);
		method(5l);
		
		method((Integer)5, 5);
	}
	
	public static void method(long l) {
		System.out.println("primitive long: " + l);
	}
	
	public static void method(short s) {
		System.out.println("primitive short: " + s);
	}
	
	public static void method(int i) {
		System.out.println("primitive int: " + i);
	}
	
	public static void method(long i, int x) {
		System.out.println("primitive with two: " + i + ", and: " + x);
	}
	
	public static void method(Integer i, int x) {
		System.out.println("primitive with short: " + i + ", and int: " + x);
	}
	
	public static void method(int i, int... a) {
		System.out.println("Variable Arguments List: " + i);
	}
}
