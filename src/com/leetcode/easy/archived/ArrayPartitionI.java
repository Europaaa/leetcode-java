package com.leetcode.easy.archived;

import java.util.Arrays;

/**
 * Array Partition I
 * Link: https://leetcode.com/problems/array-partition-i/
 */
public class ArrayPartitionI {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
