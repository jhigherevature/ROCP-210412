package methods_with_parameters;

public class Excercise1 {

	public static void main(String[] args) {

		float[] show = square(2,3,4,5);
		System.out.println(show[0] + " " + show[1] + " " + show[2] + " " + show[3]);
		
	}
	
	public static float[] square(int a, int b, int c, int d) {
		a*=a;
		b*=b;
		c*=c;
		d*=d;
		float [] values = {(float)a,(float)b, (float)c, (float)d}; 
		return values;
		}

}
