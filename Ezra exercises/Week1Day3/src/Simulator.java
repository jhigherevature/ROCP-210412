import java.util.Scanner;

public class Simulator {
	public static void main(String...args) {
	
//		nested loops ex 1
		NestedLoops1 nl = new NestedLoops1();
		nl.nestedLoop();
		
//		nested loops ex bonus
		nl.letNum();
//		nested loops ex bonus 2 name generator
		nl.nameGenerator();
		
//	
		MethodsWParam mwp = new MethodsWParam();
//		mwp._square_(1, 2, 4, 8);
//		mwp._square_(1,2,3,4,5,6,7);
		mwp._square_(7);

		String a = "a";
		String b = "a";
		if (a == b) {
			System.out.println("a equals b");
		}
		
	}
}
