package methodsWithParameters;

public class Exercise1 {
    public static float[] square(float[] numbers) {
        float[] squares = new float[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            squares[i] = numbers[i] * numbers[i];
        }
        return squares;
    }

    public static void main(String[] args) {
        float[] numbers = { 2, 3, 4, 5 };
        for (float number : square(numbers)) {
            System.out.println(number);
        }
    }
}
