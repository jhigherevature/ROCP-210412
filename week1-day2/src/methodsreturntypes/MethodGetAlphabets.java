package methodsreturntypes;

public class MethodGetAlphabets {
	/*
	 *   write a method to return an array of characters from a to z
	 * 
	 */

	public static void main(String[] args) {
	    
		char a[] = getAlphaArray();
		System.out.println(a);
	
	}
	public static char[] getAlphaArray() {
		char c;
		char []a2 = new char[26];
		int i = 0;
		for (c = 'a'; c <= 'z'; c++) {
		a2[i] = c;
		i= i +1;
		}
		return a2;
		
	}

}
