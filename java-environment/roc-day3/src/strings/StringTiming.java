package strings;

public class StringTiming {
	// This is used to control how many strings we make
	static int n = 200_000;

	public static void main(String[] args) {
		createAlotOfStrings();
//		createAlotStringBuilder();
//		createAlotStringBuffer();
	}

	/*
	 * Strings are Immutable. When we create a 
	 * string object, it cannot be changed.
	 * 
	 * String a = "Hello"; a = a + "s"; 
	 * The above example creates new String objects
	 * each time we concatenate:
	 * i.e. 
	 * b = a + * "s"; -> "Hellos" is a new object
	 * 
	 * The concat method used below performs concatenation
	 */
	public static void createAlotOfStrings() {
		String s = "";
		long timeInit = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			s = s.concat("a");
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("Strings took: " + (timeEnd - timeInit) + " ms");
	}

	public static void createAlotStringBuilder() {
		StringBuilder sb = new StringBuilder("");
		long timeInit = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			sb.append("a");
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("String Builder took: " + (timeEnd - timeInit) + " ms");
	}

	public static void createAlotStringBuffer() {
		StringBuffer sb = new StringBuffer("");
		long timeInit = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
			sb.append("a");
		}
		long timeEnd = System.currentTimeMillis();
		System.out.println("String Buffer took: " + (timeEnd - timeInit) + " ms");
	}

}
