package doWhile;

public class bonus1 {
    public static void main(String[] args) {
        char c = 'a';
        do {
            System.out.println(c);
            c += 1;
        } while (c != ('z' + 1));
    }
}
