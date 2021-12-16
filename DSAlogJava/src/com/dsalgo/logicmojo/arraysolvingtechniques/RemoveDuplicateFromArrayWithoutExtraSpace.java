package com.dsalgo.logicmojo.arraysolvingtechniques;

import java.util.Arrays;

public class RemoveDuplicateFromArrayWithoutExtraSpace {

    public static void main(String[] arg) {
        int[] arr = {1, 2, 2, 3, 4, 4, 4, 5, 5, 9, 9, 10, 11, 11, 11, 13, 14};
        removeDuplicate(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void removeDuplicate(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[j++] = arr[i];
            }
        }
        arr[j] = arr[arr.length - 1];
    }
}
