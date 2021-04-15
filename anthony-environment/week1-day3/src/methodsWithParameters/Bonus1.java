package methodsWithParameters;

public class Bonus1 {
    public static String sorter(String word1, String word2) {
        // Capital char will ruin comparisons
        String compare1 = word1.toLowerCase();
        String compare2 = word2.toLowerCase();
        for (int i = 0; i < word1.length(); ++i) {
            // Word 2 is shorter and other characters match
            if (compare2.length() < (i + 1)) {
                return word2;
            } else if (compare1.charAt(i) < compare2.charAt(i)) {
                return word1;
            } else if (compare1.charAt(i) > compare2.charAt(i)) {
                return word2;
            }
        }
        // Word 1 is shorter and other characters match
        if (word1.length() < word2.length()) {
            return word1;
        } else {
            return "Words match.";
        }
    }

    public static void main(String[] args) {
        System.out.println(sorter("Potato", "Potahto")); // Potahto
        System.out.println(sorter("ant", "ants")); // ant
        System.out.println(sorter("puddings", "pudding")); // pudding
        System.out.println(sorter("ant", "ast")); // ant
        System.out.println(sorter("Monkey", "mOnKeY")); // Words match.
    }
}
