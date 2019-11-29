package com.leetcode.easy.archived;

/**
 * Max Consecutive Ones
 * Link: https://leetcode.com/problems/max-consecutive-ones/
 */
public class MaxConsecutiveOnes {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        return Math.max(max, count);
    }
}
