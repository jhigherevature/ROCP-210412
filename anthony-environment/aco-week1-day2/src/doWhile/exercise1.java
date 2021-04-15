package doWhile;

public class exercise1 {
    public static void main(String[] args) {
        int i = 1;
        do {
            if (i % 2 == 1) {
                System.out.println(i);
            }
            ++i;
        } while (i < 50);
    }
}
