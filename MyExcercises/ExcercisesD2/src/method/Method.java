package method;

public class Method {
	
	public static float[] square(int a , int b , int c , int d ) {
		
		a = (int) Math.exp(a);
		b = (int) Math.exp(b);
		c = (int) Math.exp(c);
		d = (int) Math.exp(d);
		
		float[] arrs = { a,b,c,d };
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		
		return arrs;
		
		
		
	}
	
	public static void main(String[] args) {
		square(4,5,6,7);
	}

}
