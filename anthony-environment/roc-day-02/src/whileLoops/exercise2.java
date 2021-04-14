package whileLoops;

public class exercise2 {
    public static void main(String[] args) {
        int i = 100;
        while (i > -101) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            --i;
        }
    }
}
