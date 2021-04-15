package methodsWithParameters;

public class Exercise1 {
	
	public static void main(String[] args) {
		
		for (float index : square(2, 3, 5, 8)) {
			
			System.out.println(index);
		}
			
	}
		
	public static float[] square(int w, int x, int y, int z) {
		
		w *= w;
		x *= x;
		y *= y;
		z *= z;
		
		float[] squaredValues = {w, x, y, z};
		
		return squaredValues;
		
	}

}
