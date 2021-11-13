package com.dsalgo.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class FibSeries {

    public static void main(String[] arg) {
        Map<Integer, Integer> memo = new HashMap<>();
        System.out.println(fib(50, memo));
    }

    public static int fib(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n == 1 || n == 2) return 1;
        int fibSum = fib(n - 1, memo) + fib(n - 2, memo);
        memo.put(n, fibSum);
        return fibSum;
    }
}