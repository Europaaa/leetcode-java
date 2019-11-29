package com.leetcode.easy.archived;

/**
 * House Robber
 * Link: https://leetcode.com/problems/house-robber/
 */
public class HouseRobber {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int robV2(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int v1 = nums[0];
        int v2 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int v = Math.max(nums[i] + v1, v2);
            v1 = v2;
            v2 = v;
        }
        return v2;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int robV1(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }
}
