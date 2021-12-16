package com.dsalgo.finalpractice.array;

import java.util.Arrays;

public class Buses {

    public static void main(String[] arg) {
        int[] buses = {5};
        System.out.println(Arrays.toString(countBuses(buses, buses.length)));
    }

    public static int[] countBuses(int[] arr, int n) {
        int[] result = new int[n];
        result[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int sum = checkPreviousBuses(arr, result, i);
            result[i] = arr[i] - sum;
        }

        return result;
    }

    public static int checkPreviousBuses(int[] arr, int[] result, int i) {
        int sum = 0;
        for (int j = 0; j <= i - 1; j++) {
            if (arr[i] % arr[j] == 0) {
                sum = sum + result[j];
            }
        }
        return sum;
    }
}
