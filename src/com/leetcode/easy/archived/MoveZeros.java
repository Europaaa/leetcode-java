package com.leetcode.easy.archived;

/**
 * Move Zeros
 * Link: https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros {

    /**
     * Solution
     * - Time: O(n)
     * - Space: O(1)
     */
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
