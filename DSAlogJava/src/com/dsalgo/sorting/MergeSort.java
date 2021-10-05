package com.dsalgo.sorting;

import java.util.Arrays;

import static java.lang.System.arraycopy;

public class MergeSort {

    public static void main(String[] arg) {
        int[] inputArray = {20, 35, -15, 7, 55, 1, -22};
        mergeSort(inputArray, 0, inputArray.length - 1);
        System.out.println(Arrays.toString(inputArray));
    }

    public static void mergeSort(int[] array, int start, int end) {
        // Return from the recursion if we have single element array
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int tempIndex = 0;

        int[] tempArray = new int[end - start + 1];

        while (i <= mid && j <= end) {
            tempArray[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        // Copy left over from left array to input array
        arraycopy(array, i, array, start + tempIndex, mid - (i - 1));

        // Copy merged temp array to original array
        arraycopy(tempArray, 0, array, start, tempIndex);
    }
}
