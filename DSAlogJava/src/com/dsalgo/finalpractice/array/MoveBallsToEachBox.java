package com.dsalgo.finalpractice.array;

import java.util.Arrays;

public class MoveBallsToEachBox {

    public static void main(String[] arg) {
        String boxes = "001011";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }

    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] operations = new int[n];

        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                for (int j = 0; j < n; j++) {
                    operations[j] += Math.abs(i - j);
                }
            }

        }
        return operations;
    }
}
