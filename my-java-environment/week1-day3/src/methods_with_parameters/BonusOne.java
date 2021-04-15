package methods_with_parameters;

public class BonusOne {
	public static String findFirstWord(String str1, String str2) {
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		String returnString = "";
		int i = 0;
		do {
			if (lowerStr1.charAt(i) < lowerStr2.charAt(i)) {
				returnString = str1;
			}
			else if (lowerStr1.charAt(i) > lowerStr2.charAt(i)) {
				returnString = str2;
			}
			i++;
			if (i == (str1.length()-1)) {
				break;
			}
		}
		while (lowerStr1.charAt(i-1) == lowerStr2.charAt(i-1));
		
		if (returnString == "") {
			return str1;
		}
		else {
			return returnString;
		}

			
	}
}
