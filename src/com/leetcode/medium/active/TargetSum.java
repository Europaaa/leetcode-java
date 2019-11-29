package com.leetcode.medium.active;

/**
 * Target Sum
 * Link: https://leetcode.com/problems/target-sum/
 */
public class TargetSum {

    private static final int MAX_SUM = 1000;

    /**
     * Solution:
     * - Time: O(nk)
     * - Space: O(n)
     * where k is the range of all possible sum
     */
    public int findTargetSumWaysV2(int[] nums, int S) {
        int[] dp = new int[2 * MAX_SUM + 1];
        dp[nums[0] + MAX_SUM] = 1;
        dp[-nums[0] + MAX_SUM] += 1;

        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2 * MAX_SUM + 1];

            for (int sum = -MAX_SUM; sum <= MAX_SUM; sum++) {
                if (dp[sum + MAX_SUM] > 0) {
                    next[+nums[i] + sum + MAX_SUM] += dp[sum + MAX_SUM];
                    next[-nums[i] + sum + MAX_SUM] += dp[sum + MAX_SUM];
                }
            }
            dp = next;
        }
        return S > MAX_SUM ? 0 : dp[S + MAX_SUM];
    }

    /**
     * Solution:
     * - Time: O(2^n)
     * - Space: O(n)
     */
    public int findTargetSumWaysV1(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    private int findTargetSumWays(int[] nums, int start, int target) {
        if (start == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return findTargetSumWays(nums, start + 1, target - nums[start]) + findTargetSumWays(nums, start + 1, target + nums[start]);
    }
}
