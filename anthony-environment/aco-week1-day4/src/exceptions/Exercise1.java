package exceptions;

public class Exercise1 {
    public static int addEven(int a, int b) throws OddNumberException {
        if (a % 2 != 0 || b % 2 != 0) {
            throw new OddNumberException("Input value was odd.");
        } else {
            return (a + b);
        }
    }

    public static void main(String[] args) {
        try {
            int sum = addEven(4, 3);
            System.out.println(sum);
        } catch (OddNumberException e) {
            e.printStackTrace();
        }
    }
}
