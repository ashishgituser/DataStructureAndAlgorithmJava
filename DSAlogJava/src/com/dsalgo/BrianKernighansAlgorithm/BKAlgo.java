package com.dsalgo.BrianKernighansAlgorithm;

public class BKAlgo {

    public static void main(String[] arg) {
        System.out.println(countBit(7));
    }

    public static int countBit(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
