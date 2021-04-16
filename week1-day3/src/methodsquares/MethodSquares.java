package methodsquares;

import java.util.Arrays;

public class MethodSquares {

	public static void main(String[] args) {
		float newresult[];
		newresult = square();
		System.out.println(Arrays.toString(newresult));
		}

	public static float[] square() {
		int num1 = 7;
		int num2 = 8;
		int num3 = 9;
		int num4 = 10;
		num1 = (num1 * num1);
		num2 = (num2 * num2);
		num3 = (num3 * num3);
		num4 = (num4 * num4);
		float[] result = {num1,num2,num3,num4};
		return result;
	  }
	}


	
