package algorithms;

import java.util.Arrays;

public class Bonus1 {
    public static void bubbleSort(int[] bubbles) {
        int i = 0;
        System.out.println(Arrays.toString(bubbles) + " i=" + String.format("%2d", i));
        do {
            if (bubbles[i] > bubbles[i + 1]) {
                int x = bubbles[i];
                bubbles[i] = bubbles[i + 1];
                bubbles[i + 1] = x;
                if (i > 0) {
                    i--;
                } else {
                    i++;
                }
            } else {
                i++;
            }
            System.out.println(Arrays.toString(bubbles) + " i=" + String.format("%2d", i));
        } while (i < (bubbles.length - 1));
    }

    public static void main(String[] args) {
        int[] bubbles = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
        bubbleSort(bubbles);
    }
}