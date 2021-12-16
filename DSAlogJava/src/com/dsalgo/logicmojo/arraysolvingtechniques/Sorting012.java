package com.dsalgo.logicmojo.arraysolvingtechniques;

import java.util.Arrays;

public class Sorting012 {

    public static void main(String[] arg) {
        int[] num = {1, 0, 0, 0, 2, 0, 1, 0, 2, 0, 2, 2, 2, 0, 0, 1, 1};
        System.out.println(Arrays.toString(num));
        countSort(num);
        System.out.println(Arrays.toString(num));
    }

    public static void countSort(int[] arr) {
        int zero = 0, one = 0, two = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) zero++;
            else if (arr[i] == 1) one++;
            else two++;
        }
        int total = (zero + one + two);
        for (int i = 0; i < total; i++) {
            if (zero > 0) {
                arr[i] = 0;
                zero--;
            } else if (one > 0) {
                arr[i] = 1;
                one--;
            } else if (two > 0) {
                arr[i] = 2;
                two--;
            }
        }
    }

    public static void sortInSingleIteration(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, mid, low);
                ++low;
                ++mid;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                --high;
            } else {
                ++mid;
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
