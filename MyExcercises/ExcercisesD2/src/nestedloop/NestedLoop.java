package nestedloop;

public class NestedLoop {
	
	public static void main(String[] args) {
		
		char x ='*';
		
		for (int a = 1; a <= 1; a++ ) {
			System.out.print(x);
			System.out.println("");
			for(int b =1; b <= 2; b++) {
			System.out.print(x);
			}
			System.out.println("");
			for(int c = 1; c <= 3; c++) {
			System.out.print(x);
			}
			System.out.println("");
			for(int d =1; d <= 4; d++) {
			System.out.print(x);
			}
			System.out.println("");
			for(int e = 1; e <= 5; e++) {
			System.out.print(x);
			}
			System.out.println("");
	}
		
	}
}