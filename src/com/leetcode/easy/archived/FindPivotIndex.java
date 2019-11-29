package com.leetcode.easy.archived;

/**
 * Find Pivot Index
 * Link: https://leetcode.com/problems/find-pivot-index/
 */
public class FindPivotIndex {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
