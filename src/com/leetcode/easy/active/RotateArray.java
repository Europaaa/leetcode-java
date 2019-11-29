package com.leetcode.easy.active;

import java.util.Arrays;

/**
 * Rotate Array
 * Link: https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

    /**
     * Solution 3: Cyclic Replacements
     * - Time: O(n)
     * - Space: O(1)
     */
    public void rotateV3(int[] nums, int k) {
        int n = nums.length;

        // Normalize the value for k
        int s = k % n;

        int count = 0;
        for (int start = 0; count < n; start++) {
            int i1 = 0;
            int v1 = nums[i1];

            do {
                int i2 = (i1 + s) % n;
                int v2 = nums[i2];

                nums[i2] = v1;

                i1 = i2;
                v1 = v2;

                count++;
            } while (i1 != start);
        }
    }

    /**
     * Solution 2: Rotation
     * - Time: O(n)
     * - Space: O(1)
     */
    public void rotateV2(int[] nums, int k) {
        int n = nums.length;

        // Normalize the value for k
        int s = k % n;

        reverse(nums, 0, n - s);
        reverse(nums, n - s, n);
        reverse(nums, 0, n);
    }

    private static void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end - 1;

        while (i < j) {
            int v = nums[i];
            nums[i] = nums[j];
            nums[j] = v;

            i++;
            j--;
        }
    }

    /**
     * Solution 1: Naive solution
     * - Time: O(n)
     * - Space: O(n)
     */
    public void rotateV1(int[] nums, int k) {
        int n = nums.length;

        // Normalize the value for k
        int s = k % n;

        int[] numsCopy = Arrays.copyOf(nums, n);

        for (int i = 0; i < s; i++) {
            nums[i] = numsCopy[n - s + i];
        }
        for (int i = 0; i < n - s; i++) {
            nums[i + s] = numsCopy[i];
        }
    }
}
