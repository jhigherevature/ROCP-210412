package doWhile;

public class DoWhileOne {
	public static void main(String[] args) {
		int i = 1;
		do {
			int odd = i %2;
			if(odd == 1) {
				System.out.println(i);
			}
			
			i++;
		}while (i<50);
	}
}
