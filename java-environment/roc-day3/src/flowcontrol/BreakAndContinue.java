package flowcontrol;

public class BreakAndContinue {

	public static void main(String[] args) {
//		for (int i = 0; i <= 5; i++) {
//			System.out.println("Start of Loop");
//			System.out.println(i);
//			if (i % 2 == 1) {
//				continue;
//			}
//			System.out.println("End of Cycle");
//		}
//		
//		for (int i = 0; i <= 5; i++) {
//			System.out.println("Start of Loop");
//			System.out.println(i);
//			if (i % 2 == 1) {
//				break;
//			}
//			
//			System.out.println("End of Cycle");
//		}
		
		
		/*
		 * Labels are identifier that you can place
		 * prior to a loop or contitional statement
		 * (typically loops) that you can refer to
		 * when you use the break or continue keywords
		 */
		letters : for (char a = 'a'; a <= 'd'; a++) {
			if (a == 'c')
				break;
			
			numbers: for (int num = 0; num <= 4; num++) {
				System.out.println(a + ":" + num);
				if (num == 2) {
					continue letters;
				}
			}
		}
	}
}
