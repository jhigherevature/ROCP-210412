package methods;

public class exercise1 {
    public static int randomNumber() {
        double d = Math.random();
        return (int) (d * 50);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            System.out.println(randomNumber());
        }
    }
}
