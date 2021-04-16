package algorithms;

import java.util.Arrays;

public class Bonus2 {
    public static void mergeSorter(int[] input, int length) {
        if (length <= 1) {
            return;
        }
        int center = length / 2;
        int[] left = new int[center];
        int[] right = new int[length - center];

        for (int i = 0; i < center; i++) {
            left[i] = input[i];
        }
        for (int i = center; i < length; i++) {
            right[i - center] = input[i];
        }

        mergeSorter(left, center);
        mergeSorter(right, length - center);

        int i = 0; // input
        int j = 0; // left
        int k = 0; // right

        while (true) {
            if (j < left.length & k < right.length) {
                if (left[j] <= right[k]) {
                    input[i++] = left[j++];
                } else {
                    input[i++] = right[k++];
                }
            } else if (j < left.length) {
                input[i++] = left[j++];
            } else if (k < right.length) {
                input[i++] = right[k++];
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] splitMe = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
        System.out.println(Arrays.toString(splitMe));
        mergeSorter(splitMe, splitMe.length);
        System.out.println(Arrays.toString(splitMe));
    }
}
