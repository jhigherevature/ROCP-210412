
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
	public void findFirstWord(String a, String b) {
//		a = ;
//		b = ;
		String a1 = a.substring(0, 1);
		String b1 = b.substring(0, 1);
		if (a1 == b1) {
//			then move onto next letter
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