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

	
		int [] a = {1,2,4,5,7,8,0,};
		int [] b = {4,5,6,7,8,9,};
		mwp.displayArrayStatistics(a,b);
		
	}
}
