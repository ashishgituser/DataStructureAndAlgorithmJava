package com.dsalgo.sorting;

/*
About Insertion sort:
========================

1. Insert an element from unsorted array to it' correct position in sorted array.


How it works
================

1. Take the 1 index element from array which becomes the current element.
2. Now, we will start comparing each element from start to current element position - 1;
3. If the element is greater than the current element, then we will shift those elements to right.
4. At the end, we will insert the current element to it's right sorted position.

Time Complexity
======================

Time Complexity: O(n^2)
Auxiliary Space: O(1)
Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
Algorithmic Paradigm: Incremental Approach
Sorting In Place: Yes
Stable: Yes
 */

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] arg) {
        int[] elements = {2, 3, 1, 6, 2, 7, 5, 3, 2};
        insertionSort(elements);
        System.out.println(Arrays.toString(elements));
    }

    public static void insertionSort(int[] arr) {
        if (arr.length == 1) return;

        for (int i = 1; i < arr.length; i++) {
            int currentElement = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > currentElement) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = currentElement;
        }
    }
}
