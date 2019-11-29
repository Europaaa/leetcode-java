package com.leetcode.easy.active;

/**
 * Merge Sorted Array
 * Link: https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }

        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public void mergeV1(int[] nums1, int m, int[] nums2, int n) {
        int size = nums1.length;

        // Move the values in nums1 to the end
        for (int i = m - 1; i >= 0; i--) {
            nums1[size - m + i] = nums1[i];
        }

        // Merge sort nums1[(size-m):] and nums2
        int i = size - m;
        int j = 0;
        int k = 0;

        for (; i < size && j < n; k++) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums1[i++];
            } else {
                nums1[k] = nums2[j++];
            }
        }

        for (; i < size; i++) {
            nums1[k++] = nums1[i];
        }
        for (; j < n; j++) {
            nums1[k++] = nums2[j];
        }
    }
}
