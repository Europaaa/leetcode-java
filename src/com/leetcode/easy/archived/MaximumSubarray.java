package com.leetcode.easy.archived;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Maximum Subarray
 * Link: https://leetcode.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int maxSubArrayV2(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        // dp[i] represents that the max sum of all subarrays ending at nums[i]
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        return Arrays.stream(dp).boxed().max(Comparator.naturalOrder()).get();
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int maxSubArrayV1(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        // dp1[i] represents that the sum of the max subarray that includes i
        int[] dp1 = new int[n];
        dp1[0] = nums[0];

        // dp1[i] represents that the sum of the max subarray that not includes i
        int[] dp2 = new int[n];
        dp2[0] = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            dp1[i] = Math.max(dp1[i - 1] + nums[i], nums[i]);
            dp2[i] = Math.max(dp2[i - 1], dp1[i - 1]);
        }

        return Math.max(dp1[n - 1], dp2[n - 1]);
    }
}
