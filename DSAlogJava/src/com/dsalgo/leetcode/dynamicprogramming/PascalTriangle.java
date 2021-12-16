package com.dsalgo.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] arg) {
        System.out.println(generate(5));
        System.out.println(stepsRequired(7));
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(getRow(3));
        System.out.println(maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(getMaximumGenerated(7));
        System.out.println(climbStairsTabulation(6));

    }

    public static int climbStairsTabulation(int n) {
        if (n == 0) return 0;

        int[] table = new int[n + 1];
        table[0] = 1;
        table[1] = 1;

        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 2] + table[i - 1];
        }

        return table[n];
    }

    public static int climbStairs(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    public static int getMaximumGenerated(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 1; i <= n; i++) {
            if ((2 * i) <= n) {
                nums[(2 * i)] = nums[i];
            }
            if ((2 * i) + 1 <= n) {
                nums[(2 * i) + 1] = nums[i] + nums[i + 1];
            }
        }

        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i=0; i<prices.length - 1; i++) {
            int buy = prices[i];
            int maxSellPrice = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > maxSellPrice) {
                    maxSellPrice = prices[j];
                }
            }
            int profit = maxSellPrice - buy;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> output = new ArrayList<>();

        output.add(Arrays.asList(1));
        if (rowIndex == 0) return output.get(rowIndex);

        output.add(Arrays.asList(1, 1));
        if (rowIndex == 1) return output.get(rowIndex);

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> tempArray = new ArrayList<>();
            List<Integer> preArray = output.get(i - 1);

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tempArray.add(1);
                }
                else {
                    tempArray.add(preArray.get(j - 1) + preArray.get(j));
                }
            }

            output.add(tempArray);
        }
        return output.get(rowIndex);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length + 1];
        return Math.min(minCostClimbingStairs(cost, 0, memo), minCostClimbingStairs(cost, 1, memo));
    }

    public static int minCostClimbingStairs(int[] cost, int n, int[] memo) {
        if (n >= cost.length) return 0;
        if (memo[n] != 0) return memo[n];
        int result = Math.min(minCostClimbingStairs(cost, n + 1, memo), minCostClimbingStairs(cost, n + 2, memo)) + cost[n];
        memo[n] = result;
        return result;
    }

    public static int stepsRequired(int no) {
        if (no < 0) return 0;
        if (no == 0) return 1;
        return stepsRequired(no - 2) + stepsRequired(no - 1);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();

        output.add(Arrays.asList(1));
        if (numRows == 1) return output;

        output.add(Arrays.asList(1, 1));
        if (numRows == 2) return output;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> tempArray = new ArrayList<>();
            List<Integer> prevArray = output.get(i - 2);

            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    tempArray.add(1);
                } else {
                    int result = prevArray.get(j - 1) + prevArray.get(j);
                    tempArray.add(result);
                }
            }
            output.add(tempArray);
        }
        return output;
    }
}
