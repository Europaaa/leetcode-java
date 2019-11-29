package com.leetcode.easy.archived;

/**
 * Largest Number At Least Twice of Others
 * Link: https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 */
public class LargestNumberAtLeastTwiceOfOthers {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int dominantIndex(int[] nums) {
        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[k]) {
                k = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == k) {
                continue;
            }
            if (2 * nums[i] > nums[k]) {
                return -1;
            }
        }
        return k;
    }
}
