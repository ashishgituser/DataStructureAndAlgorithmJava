package com.dsalgo.logicmojo.arraysolvingtechniques;

public class JumpGame {

    public static void main(String[] arg) {
        int[] nums = {1, 1, 3, 1, 1};
        System.out.println(noOfJump(nums));
    }

    public static int noOfJump(int[] nums) {
        int maxValue = nums[0];
        int step = nums[0];
        int jumps = 1;

        for (int i = 1; i < nums.length; i++) {

            maxValue = Math.max(maxValue, nums[i]);
            step = step - 1;

            if (step == 0) {
                jumps++;
                step = maxValue;
            }
        }
        return jumps;
    }
}
