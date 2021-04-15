package methods_with_parameters;

public class Bonus1 {

	public static void main(String[] args) {
		
		System.out.println(findFirstWord("Eric","Adam"));
		
	}
	
	public static String findFirstWord(String a, String b) {
		
		if (a == null || b == null) {
			
			return "-1";
			
		}
		
		for (int i = 0; i < a.length(); i++) {
			
			if (a.charAt(i) < b.charAt(i)) {
				
				return a;
				
			}
			
			if (a.charAt(i) > b.charAt(i)){
				
				return b;
				
			}
			
		}
		
		return "These words are the same";
		
	}

}
