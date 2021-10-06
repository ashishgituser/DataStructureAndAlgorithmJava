package com.dsalgo.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] arg) {
        int[] inputArray = {20, 35, -15, 7, 55, 1, -22};
        quickSort(inputArray, 0, inputArray.length - 1);
        System.out.println(Arrays.toString(inputArray));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;

        // Mid element as pivot.
        int pivot = array[(left + (right - left) / 2)];
        int pi = partition(array, left, right, pivot);
        System.out.println(pi);
        quickSort(array, left, pi - 1);
        quickSort(array, pi, right);
    }

    public static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
