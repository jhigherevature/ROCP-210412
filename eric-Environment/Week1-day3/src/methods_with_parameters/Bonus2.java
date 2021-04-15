package methods_with_parameters;

public class Bonus2 {

	public static void main(String[] args) {
		
		int[] one = {2,2,2,12,9};
		int[] two = {12,13,14,15,16,21};
		
		displayArrayStatistics(one,two);
		
	}
	
	public static void displayArrayStatistics(int[] a, int[] b) {
		
		//find which has more even numbers
		int aCount = 0;
		int bCount = 0;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				aCount++;
			}
		for (int i2 = 0; i2 < b.length; i2++) {
			if (b[i2] % 2 == 0) {
				bCount++;
			}	
		}
		
	}
		
		if (aCount > bCount) {
			System.out.println("A contains more even numbers");
		}
		else if (aCount < bCount){
			System.out.println("B contains more even numbers");
		}
		else {
			System.out.println("These arrays contain the same ammount of even numbers");
		}
		//find which has more data
		
		if (a.length > b.length) {
			System.out.println("A has more data");
		}
		else if (a.length < b.length) {
			System.out.println("B has more data");
		}
		else {
			System.out.println("A and B have the same ammount of data");
		}
		//find which has more multiples of 3
		
		aCount = 0;
		bCount = 0;
		
		for (int i3 = 0; i3 < a.length; i3++) {
			if (a[i3] % 3 == 0) {
				aCount++;
			}
		}
		for (int i4 = 0; i4 < b.length; i4++) {
			if (b[i4] % 2 == 0) {
				bCount++;
			}	
		}
		
		if (aCount > bCount) {
			System.out.println("A contains more multiples of 3");
		}
		else if (aCount < bCount){
			System.out.println("B contains more multiples of 3");
		}
		else {
			System.out.println("These arrays contain the same ammount of multiples of 3");
		}
		
		}
}
		
		
		
	
	

	


