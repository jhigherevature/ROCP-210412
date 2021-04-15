package nestedLoops;

public class Bonus1 {
    public static void charNumber(char[] forbiddenChar) {
        int i = 1;
        charloop: for (char c = 'a'; c < ('z' + 1); ++c) {
            for (char d : forbiddenChar) {
                if (c == d) {
                    ++i;
                    continue charloop;
                }
            }
            System.out.println(c + " - " + i++);
        }
    }

    public static void main(String[] args) {
        char[] forbiddenChar = { 'a', 'e', 'i', 'o', 'u' };
        charNumber(forbiddenChar);
    }
}
