package com.dsalgo.sorting;

/*
About Counting sort:
========================
1. Make assumption about the data.
2. Don't use comparisons.
3. Count the number of occurrences of each value.
4. Only works with non-negative discrete values (can't work for float, strings.)
5. Value must be within the specific range.

How it works:
========================
1. Take the maximum element from the array.
2. Create count array of size max to count the occurrence of each element and store the count in count array.
3. Modify the count array to store actual position of element.
4. Create a new array of size of original array.
5. Iterate original array from right to left, take the element which becomes the index of count array, take the count
   from count array then decrement count by one which becomes the index of new array then store the element to that position.
6. Store elements from new array to original array.

Some points about counting sort:
=================================
1. Not an in-place algorithm.
2. O(n) - can achieve this because we are making assumptions about the data we are sorting.
3. If we want the sort to be stable, we have to do some extra steps.
 */

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] arg) {
        int[] elements = {0,0,0,1,1,0,1,0,1,0,0,0,1,1,1};
        countingSort(elements);
        System.out.println(Arrays.toString(elements));
    }

    public static void countingSort(int[] arr) {

        // Find the max element from the original array
        int max = max(arr);

        // Create a new array of max + 1 length
        int[] countArray = new int[max + 1];

        // Store occurrence of each element to count array
        for (int i = 0; i < arr.length; i++) {
            countArray[arr[i]]++;
        }

        // Modify the count array to store the actual position of element by adding (current element count + it's previous count)
        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        // Create a temp array of size of original array.
        int[] tempArray = new int[arr.length];

        // Start placing elements to their actual sorted position in tempArray
        for (int i = arr.length - 1; i >= 0; i--) {
            tempArray[--countArray[arr[i]]] = arr[i];
        }

        // Copy the sorted elements from tempArray to original array.
        System.arraycopy(tempArray, 0, arr, 0, arr.length - 1);
    }

    // Take the max element by linear search approach
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
}
