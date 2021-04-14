package methodsreturntypes;

public class MethodGetPi {

	/*
	 *   write a method to return the value of Pi
	 * 
	 */
	
	public static void main(String[] args) {
		double num1 = 0;
		num1 = getPi();
		System.out.println("Value of Pi = " + num1);
	
	}
	public static double getPi() {
		double num2 = Math.PI;
		return num2;
	}

}
