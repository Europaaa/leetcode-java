package com.leetcode.easy.active;

/**
 * Remove Element
 * Link: https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }
        return j + 1;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int removeElementV1(int[] nums, int val) {
        int n = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[n++] = nums[i];
            }
        }
        return n;
    }
}
