package com.dsalgo.searching;

public class BinarySearch {

    public static void main(String[] arg) {
        int[] inputArray = {1, 4, 6, 8, 9, 11, 43, 66};
        System.out.println(binarySearch(inputArray, 9, 0, inputArray.length - 1));
    }

    public static int binarySearch(int[] array, int key, int left, int right) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (key == array[mid]) {
            return mid;
        } else if (key < array[mid]) {
            return binarySearch(array, key, left, mid - 1);
        } else {
            return binarySearch(array, key, mid + 1, right);
        }
    }
}
