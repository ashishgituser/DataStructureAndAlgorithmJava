package com.dsalgo.tree.fenwick;

import java.util.Arrays;

public class FenwickTree {

    public static void main(String[] arg) {

        int[] arr = {5, 7, 9, -2, 5, 3};
        System.out.println(Arrays.toString(arr));
        int[] tree = construct(arr);
        System.out.println(Arrays.toString(tree));
        //System.out.println(get(tree, arr, 2));
        System.out.println(sum(tree, 1, 3));
    }

    public static int[] construct(int[] oArray) {
        int[] tree = Arrays.copyOf(oArray, oArray.length);
        int parent;
        for (int i = 1; i < oArray.length; i++) {
            // or -> parent = i + Integer.lowestOneBit(i);
            // 1 - 00001 => 00001 + 1  = 1 + 1 = 2
            // 2 - 00010 => 00010 + 10 = 2 + 2 = 4
            // 3 - 00011 => 00011 + 1  = 3 + 1 = 4
            parent = i + (i & -i);
            //System.out.println(oArray[i] + "  | " + i + "  | " + Integer.toBinaryString(i) + "  | " + Integer.toBinaryString(parent));
            //System.out.println(parent);
            if (parent < oArray.length) tree[parent] += tree[i];
        }
        return tree;
    }

    public static int sum(int[] tree, int i, int j) {
        return prefixSum(tree, j) - prefixSum(tree,i - 1);
    }

    public static int get(int[] tree, int[] oArray, int i) {
        return prefixSum(tree, i) - prefixSum(oArray, i - 1);
    }

    public static int prefixSum(int[] tree, int i) {
        int sum = 0;
        while (i > 0) {
            System.out.println(i);
            sum += tree[i];
            i = i - (i & -i);
        }
        return sum;
    }
}
