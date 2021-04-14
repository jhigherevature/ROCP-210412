package methodsWithReturnTypes;

public class exercise1 {
    public static char[] getAlphabetArray() {
        char[] array = new char[26];
        int i = 0;
        for (char c = 'a'; c < ('z' + 1); c++) {
            array[i] = c;
            i++;
        }
        return array;
    }

    public static void main(String[] args) {
        char[] c = getAlphabetArray();
        for (char i : c) {
            System.out.println(i);
        }
    }
}
