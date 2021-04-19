package method_parameters;

public class method_parameters {
	static void square(int a, int b, int c, int d) {
		float[] squareflt = {a,b,c,d};
		System.out.print(squareflt);
	}
	
	public static void main(String[] args) {
		square(7,5,2,3);
	}
}
