package methodsWithParameters;

public class Bonus2 {
    public static void displayArrayStatistics(int[] a, int[] b) {
        int evenA = 0;
        int evenB = 0;
        int lengthA = a.length;
        int lengthB = b.length;
        int threesA = 0;
        int threesB = 0;

        for (int x : a) {
            if (x % 2 == 0) {
                ++evenA;
            } else if (x % 3 == 0) {
                ++threesA;
            }
        }

        for (int x : b) {
            if (x % 2 == 0) {
                ++evenB;
            } else if (x % 3 == 0) {
                ++threesB;
            }
        }

        if (evenA > evenB) {
            System.out.println("A contains more even numbers.");
        } else if (evenA < evenB) {
            System.out.println("B contains more even numbers.");
        } else {
            System.out.println("Both arrays contain the same count of even numbers.");
        }

        if (lengthA > lengthB) {
            System.out.println("A contains more total numbers.");
        } else if (lengthA < lengthB) {
            System.out.println("B contains more total numbers.");
        } else {
            System.out.println("Both arrays contain the same count of total numbers.");
        }

        if (threesA > threesB) {
            System.out.println("A contains more multiples of 3.");
        } else if (threesA < threesB) {
            System.out.println("B contains more multiples of 3");
        } else {
            System.out.println("Both arrays contain the same count of multiples of 3.");
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        int[] b = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 };
        displayArrayStatistics(a, b);
    }
}
