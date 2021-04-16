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
		
//		Scanner stuff
		Scanner scan = new Scanner(System.in);
		scannerVowelNum();
	}

	private static void scannerVowelNum() {
		System.out.println("Give me some of that sweet sweet data");
		Scanner scan = new Scanner(System.in);
//		String S = scan.next();
		String input = scan.nextLine();
		System.out.println("You typed: "+ input);

		int count = 0;
		
		for (int i = 0; i < input.length(); i++) {
			
		switch (input.charAt(i)) {
		case 'a': 
			count++;
			break;
		case 'e':
			count++;
			break;
		case 'i': 
			count++;
			break;
		case 'o':
			count++;
			break;
		case 'u': 
			count++;
			break;
		default:
			break;
		}
		}
		System.out.println("There are " + count + " vowels in your sentence.");
	}
}
