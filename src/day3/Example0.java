package day3;

public class Example0 {

	public static void main(String[] args) {

		int a = 5;
		int b = 6;
		int c = 10;
		int d = 4;
		
		_square_(a, b, c, d);
	}

	public static float[] _square_(int a, int b, int c, int d) {

		float aSquared = (float) Math.pow(a, 2);
		float bSquared = (float) Math.pow(b, 2);
		float cSquared = (float) Math.pow(c, 2);
		float dSquared = (float) Math.pow(d, 2);
		
		 float[] squares = {aSquared,bSquared,cSquared,dSquared};
		 
		return squares;

	}
}
