package operators;

public class Ternary {
	
	/*
	 * Ternary operators act as a shorthan
	 */

	public static void main(String[] args) {
	int x = (true) ? 15 : 25;
	int y = (false) ? 15 : 25;
	
	String message = (x < y) ? "X less than Y" : "Y less than X";
	System.out.println(message);

	
	String other;
	if( x < y) {
		other  = "X less than Y";
		
	}else {
		other = "Y less than X";
	}
	System.out.println(other);
	}

}
