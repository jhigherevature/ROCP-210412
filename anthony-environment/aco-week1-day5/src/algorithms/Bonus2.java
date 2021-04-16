package algorithms;

import java.util.Arrays;

public class Bonus2 {
    public static void splitter(int[] input, int length) {
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

        splitter(left, center);
        splitter(right, length - center);

        merger(input, left, right, left.length, right.length);
    }

    public static void merger(int[] input, int[] left, int[] right, int lLen, int rLen) {
        int i = 0; // input
        int j = 0; // left
        int k = 0; // right

        while (true) {
            if (j < lLen & k < rLen) {
                if (left[j] <= right[k]) {
                    input[i++] = left[j++];
                } else {
                    input[i++] = right[k++];
                }
            } else if (j < lLen) {
                input[i++] = left[j++];
            } else if (k < rLen) {
                input[i++] = right[k++];
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] splitMe = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
        System.out.println(Arrays.toString(splitMe));
        splitter(splitMe, splitMe.length);
        System.out.println(Arrays.toString(splitMe));
    }
}
