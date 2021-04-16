
public class MethodsWParam {
	
	public float[] _square_(int a, int b, int c, int d) {
		a*=a; 
		b*=b;
		c*=c;
		d*=d;
		float fa = a;
		float fb = b;
		float fc = c;
		float fd = d;
		float [] flarr = {fa,fb,fc,fd};
		for (int i = 0; i <= flarr.length-1; i++) {
			System.out.println(flarr[i]);
		}
		return flarr;
	}
	
//	attempt to make it more robust - I don't think it works...IT WORKS!!!!!!!!!!!!!
//	method overloading! what! what!!!
	public float[] _square_(int... args) {
//		create an empty float array of the length of the number of inputed args
		float [] array = {args.length-1};
//		for each arg: square it then convert it to a float variable
	      for (int arg : args) {
	    	  arg*=arg;
	    	  float farg = arg;
//	    input each converted variable into float array
	    	  for (int i = 0; i <= array.length-1; i++) {
					array[i] = farg;
	      }
//	    print out float array for testing
	      for (int i = 0; i <= array.length-1; i++) {
				System.out.println(array[i]);
		  }
	      }
//	     return float array
		return array;
	}
	
//	bonus 1 methodWParamaters
	public String findFirstWord(String a, String b) {
		if (a.equalsIgnoreCase(b)) {
			System.out.println("They are the same word");
			return a;
		}
		a = a.toLowerCase();
		b = b.toLowerCase();
		String StrLen;
		
		if (a.length() <= b.length()) {
			StrLen = a;
		}
		else {
			StrLen = b;
		}
		
		for (int i=0; i<StrLen.length(); i++) {
			if (a.charAt(i) == b.charAt(i)) {
				continue;
			}
			if (a.charAt(i) > b.charAt(i)) {
				System.out.println(a +" is the first word");
				return a;
			}
			if (a.charAt(i) < b.charAt(i)) {
				System.out.println(b +" is the first word");
				return b;
			}
		
		}
		return StrLen;

	}
	
	
//	bonus 2 Methods With Parameters

	public void displayArrayStatistics(int[] a, int[] b) {
//		System.out.println(a[0]);		//checking if input can work
//		System.out.println(b[0]);		//checking if input can work
//		part 1 which array contains more even numbers?
		int evenCountA = 0;
		int evenCountB = 0;
		int Count3A = 0;
		int Count3B = 0;
		for(int i=0; i<=a.length-1;i++) {
			if (a[i]%2 == 0) {
				evenCountA++;
			}
		}
		for(int j=0; j<=b.length-1;j++) {
			if (b[j]%2 == 0) {
				evenCountB++;
			}
		}
		if (evenCountA > evenCountB) {
			System.out.println("A contains more even numbers");
		}
		else if (evenCountA < evenCountB) {
				System.out.println("B contains more even numbers");
		}
		else {
			System.out.println("Neither A nor B contains more even numbers");
		}
		
//	part 2 count and compare amount of data in each
		if (a.length > b.length) {
			System.out.println("A contains more data");
		}
		else if (a.length < b.length) {
				System.out.println("B contains more data");
		}
		else {
			System.out.println("A and B contain the same amount of data");			
			}
			
//	part 3 which array contains more values that are multiple of 3
		
		for(int k=0; k<=a.length-1;k++) {
			if (a[k]%3 == 0) {
				Count3A++;
			}
		}
		for(int m=0; m<=b.length-1;m++) {
			if (b[m]%3 == 0) {
				Count3B++;
			}
		}
		if (Count3A > Count3B) {
			System.out.println("A contains more numbers divisible by 3");
		}
		else if (Count3A < Count3B) {
				System.out.println("B contains more even numbers divisible by 3");
		}
		else {
			System.out.println("Neither A nor B contains more numbers divisible by 3");
		}
	}	
}




//bonus 1
//Create a method that declares two String parameters. This method should search through each parameter and determine the value that should come first if they were sorted alphabetically. Whichever value is first from both parameters should be returned. Name the method findFirstWord.
//You can assume that both inputs are the same length and are actual words (not numbers). You can also assume that the length of each word will be at least 3 letters.

//Question 1 Methods W Parameters
	//Create a method that declares four int parameters, squares each, and places the results in a float array. 
//The method should return the float array result. 
//		Name the method _square_.