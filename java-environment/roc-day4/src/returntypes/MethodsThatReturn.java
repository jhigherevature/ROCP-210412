package returntypes;

public class MethodsThatReturn {
	String name;
	
	public static void main(String[] args) {
		int x = add(3,7);
		
		System.out.println( 5 + 5 - 3);
		System.out.println( add(5,5) - 3);
		
		int y = 10 - 5;
		System.out.println(subtract( add(7,8) , 5) );
	}
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	public static int subtract(int a, int b) {
		return a - b;
	}

}
