package com.leetcode.easy.archived;

/**
 * Two Sum II - Input array is sorted
 * Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumIIInputArrayIsSorted {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0; int j = numbers.length - 1;
        for (; i < j;) {
            int v = numbers[i] + numbers[j];
            if (v > target) {
                j--;
            }
            else if (v < target) {
                i++;
            }
            else {
                return new int[] {i + 1, j + 1};
            }
        }
        throw new IllegalStateException();
    }
}
