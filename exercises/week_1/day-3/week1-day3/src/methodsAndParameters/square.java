package methodsAndParameters;

public class square {
/*
 * # Exercise 1

Create a method that declares four int parameters, squares each, 
and places the results in a float array. 
The method should return the float array result. Name the method _square_.
 */
	public float[] sqr(int a, int b, int c, int d) {
		
		float[] squareArray = {a*a,b*b,c*c,d*d};
		
		return squareArray;
	}
	
	public static void main(String[] args) {
		
		square f = new square();
		//float[] F = f.sqr(1,2, 3, 4);
		System.out.println((f.sqr(1, 2, 3, 4))[2]);
		
		
		
	}

}
