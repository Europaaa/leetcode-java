package com.leetcode.medium.archived;

/**
 * Minimum Size Subarray Sum
 * Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // Find the min length for the sub-array starting from nums[0]
        int length = 0;
        int sum = 0;

        for (; length < n && sum < s; length++) {
            sum += nums[length];
        }

        if (sum < s) {
            return 0;
        }

        int minLength = length;

        // Find the min length for the sub-array starting from nums[i]
        for (int i = 1; i < n; i++) {
            length = length - 1;
            sum = sum - nums[i - 1];

            for (; i + length < n && sum < s; length++) {
                sum += nums[i + length];
            }

            if (sum < s) {
                break;
            }

            minLength = Math.min(minLength, length);
        }
        return minLength;
    }

}
