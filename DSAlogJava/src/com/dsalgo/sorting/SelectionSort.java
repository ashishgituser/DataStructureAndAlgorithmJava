package com.dsalgo.sorting;

import java.util.Arrays;

/*
About Selection Sort and how it works
========================================

The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two sub-arrays in a given array.
1) The sub-array which is already sorted.
2) Remaining sub-array which is unsorted.
In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted sub-array is picked and moved to the sorted sub-array.

Complexity
===================

Time Complexity: O(n2) as there are two nested loops.
Auxiliary Space: O(1)
The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.

 */
public class SelectionSort {

    public static void main(String[] arg) {
        int[] elements = {5, 2, 3, 1};
        selectionSort(elements);
        System.out.println(Arrays.toString(elements));
    }

    public static void selectionSort(int[] arr) {
        int minElementIndex, temp;

        for (int i = 0; i < arr.length - 1; i++) {
            minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            temp = arr[minElementIndex];
            arr[minElementIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
