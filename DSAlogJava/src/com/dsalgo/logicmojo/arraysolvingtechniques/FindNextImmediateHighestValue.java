package com.dsalgo.logicmojo.arraysolvingtechniques;

import java.util.Arrays;
import java.util.List;

public class FindNextImmediateHighestValue {

    public static void main(String[] arg) {
        int[] n = {1, 2};
        System.out.println(Arrays.toString(getNextHigherValue(n)));
    }

    public static int[] getNextHigherValue(int[] n) {
        if (n.length == 0 || n.length == 1) return n;
        return n;
    }


    public static void swap(int[] n, int i, int j) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }

    public static void convertToArray(int n, List<Integer> arr) {
        if (n <= 0) return;
        int v = n % 10;
        n = n / 10;
        convertToArray(n, arr);
        arr.add(v);
    }
}
