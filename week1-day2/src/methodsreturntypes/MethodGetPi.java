package methodsreturntypes;

public class MethodGetPi {

	public static void main(String[] args) {
		double num1 = 0;
		getPi(num1);
		System.out.println("Value of Pi = " + num1);
	
	}
	public static double getPi(double num1) {
		double num2 = Math.PI;
		return num2;
	}

}
