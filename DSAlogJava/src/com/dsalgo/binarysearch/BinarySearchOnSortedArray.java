package com.dsalgo.binarysearch;

import java.util.Arrays;

public class BinarySearchOnSortedArray {

    public static void main(String[] arg) {
        int[] n = {5, 6, 7, 1, 2, 3};
        int[] n1 = {1, 3, 4, 5, 7, 8, 9};

        System.out.println(binarySearchRecursive(n, 0, n.length - 1, 6));
        System.out.println(findMaximum(n, 0, n.length - 1));
        System.out.println(findLargestThanGivenN(n1, 0, n1.length - 1, 9));
        System.out.println(findSmallestThanGivenN(n1, 0, n1.length - 1, 9));
        System.out.println(sumOfSortedArray(n1, 0, n1.length - 1));
        pairExist(n1, 0, n1.length - 1, 13);
        System.out.println((0 < 0));
    }

    public static void pairExist(int[] array, int low, int high, int num) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            pairExist(array, low, mid, num);
            pairExist(array, mid + 1, high, num);
            checkForPair(array, low, mid, num);
            checkForPair(array, mid + 1, high, num);
        }
    }

    public static void checkForPair(int[] array, int start, int end, int num) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += array[i];
        }
        if (sum == num) System.out.println("Pair exist: " + sum);
    }

    public static int sumOfSortedArray(int[] array, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            sumOfSortedArray(array, low, mid);
            sumOfSortedArray(array, mid + 1, high);
            return doSum(array, low, mid) + doSum(array, mid + 1, high);
        }
        return -1;
    }

    public static int doSum(int[] array, int low, int high) {
        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int findLargestThanGivenN(int[] nums, int low, int high, int num) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (nums[mid] == num) {
            return mid < nums.length - 1 ? nums[mid + 1] : nums[mid];
        } else if (nums[mid] > num) {
            return findLargestThanGivenN(nums, low, mid - 1, num);
        } else {
            return findLargestThanGivenN(nums, mid + 1, high, num);
        }
    }

    public static int findSmallestThanGivenN(int[] nums, int low, int high, int num) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (nums[mid] == num) {
            return mid <= 0 ? nums[0] : nums[mid - 1];
        } else if (nums[mid] > num) {
            return findSmallestThanGivenN(nums, low, mid - 1, num);
        } else {
            return findSmallestThanGivenN(nums, mid + 1, high, num);
        }
    }

    public static int findMaximum(int[] arr, int low, int high) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (mid < arr.length - 1 && arr[mid + 1] < arr[mid])
            return arr[mid];

        if (arr[high] > arr[mid])
            return findMaximum(arr, low, mid - 1);
        else
            return findMaximum(arr, mid + 1, high);
    }

    public static int binarySearchRecursive(int[] n, int low, int high, int num) {
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (n[mid] == num) return mid;
        else if (n[mid] > num) return binarySearchRecursive(n, low, mid - 1, num);
        else return binarySearchRecursive(n, mid + 1, high, num);
    }
}
