package com.leetcode.easy.active;

import java.util.Arrays;

/**
 * Convert Sorted Array to Binary Search Tree
 * Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class ConvertSortedArrayToBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(log n)
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int size = end - start;

        if (size <= 0) {
            return null;
        }
        if (size == 1) {
            return new TreeNode(nums[start]);
        }

        int middle = start + (size - 1) / 2;

        TreeNode node = new TreeNode(nums[middle]);
        node.left = sortedArrayToBST(Arrays.copyOfRange(nums, start, middle));
        node.right = sortedArrayToBST(Arrays.copyOfRange(nums, middle + 1, end));
        return node;
    }
}
