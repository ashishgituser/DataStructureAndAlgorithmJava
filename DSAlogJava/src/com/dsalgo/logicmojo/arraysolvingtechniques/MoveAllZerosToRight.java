package com.dsalgo.logicmojo.arraysolvingtechniques;

import java.util.Arrays;

public class MoveAllZerosToRight {

    public static void main(String[] arg) {
        int[] nums = {1, 0, 1};
        System.out.println(Arrays.toString(nums));
        moveZerosToRight(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZerosToRight(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != 0) arr[count++] = arr[i];
        while (count < arr.length)
            arr[count++] = 0;
    }
}
