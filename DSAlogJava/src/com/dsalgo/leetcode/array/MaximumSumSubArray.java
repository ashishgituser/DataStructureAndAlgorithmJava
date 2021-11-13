package com.dsalgo.leetcode.array;

/*
public int maxSubArray(int[] nums) {
       int currMax = 0;
       int max = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            int sum = currMax + nums[i];
            currMax = Math.max(sum, nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }
 */

public class MaximumSumSubArray {

    public static void main(String[] arg) {
        int[] nums = {-2, 1, -3};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        return maxSubArrayDivide(nums, 0, nums.length - 1);
    }

    public static int maxSubArrayDivide(int[] nums, int low, int high) {
        if (low == high) return nums[low]; // If only one element left

        int mid = low + (high - low) / 2;

        System.out.println(mid);

        int leftSubArraySum = maxSubArrayDivide(nums, low, mid);
        int rightSubArraySum = maxSubArrayDivide(nums, mid + 1, high);

        int sumOfSubArrays = sumOfSubArray(nums, low, mid, high);

        return Math.max(Math.max(leftSubArraySum, rightSubArraySum), sumOfSubArrays);
    }

    public static int sumOfSubArray(int[] arr, int l, int m, int h) {
        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = m + 1; i <= h; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        return Math.max(left_sum + right_sum,
                Math.max(left_sum, right_sum));
    }
}
