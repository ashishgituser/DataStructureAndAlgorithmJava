package com.dsalgo.leetcode.array;

import java.util.concurrent.TimeUnit;

public class LargestNumberInIncreasingDecreasingArray {
    private static int TOTAL_ITERATION = 0;

    public static void main(String[] arg) throws InterruptedException {
        int[] inputArray = prepareNumbers();

        Long start = System.nanoTime();
        int maxNumber = findMaximumNumber(inputArray, 0, inputArray.length - 1);
        Long end = System.nanoTime();

        Long totalTimeTaken = TimeUnit.SECONDS.convert((end - start), TimeUnit.NANOSECONDS);

        System.out.println("Max number: " + maxNumber);
        System.out.println("Iterations: " + TOTAL_ITERATION);
        System.out.println("Time taken (Seconds): " + totalTimeTaken);
    }

    public static int findMaximumNumber(int[] array, int start, int end) {
        TOTAL_ITERATION++;
        if (start == end) return array[start];

        if (end == start + 1) {
            if (array[start] >= array[end]) {
                return array[start];
            } else {
                return array[end];
            }
        }

        int mid = start + (end - start) / 2;

        if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
            return array[mid];
        } else if (array[mid] > array[mid + 1] && array[mid] < array[mid - 1]) {
            return findMaximumNumber(array, start, mid - 1);
        } else {
            return findMaximumNumber(array, mid + 1, end);
        }
    }

    private static int[] prepareNumbers() {
        int[] numbers = new int[Integer.MAX_VALUE / 10];
        for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
            numbers[i] = i;
        }
        return numbers;
    }
}
