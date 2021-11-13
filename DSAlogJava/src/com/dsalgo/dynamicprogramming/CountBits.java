package com.dsalgo.dynamicprogramming;

import java.util.Arrays;

public class CountBits {

    public static void main(String[] arg) {
        System.out.println(Arrays.toString(countBits(5)));
        System.out.println((2 % 2));
    }

    public static int[] countBits(int n) {
        int[] bitCount = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bitCount[i] = (int) noOfBits(i);
        }
        return bitCount;
    }

    public static long noOfBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
