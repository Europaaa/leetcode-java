package com.leetcode.easy.archived;

/**
 * Search in a Binary Search Tree
 * Link: https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInABinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Solution: Iterative
     * - Time: O(h)
     * - Space: O(1)
     * where h is the height of the tree, O(n) worst case
     */
    public TreeNode searchBSTV2(TreeNode root, int val) {
        TreeNode node = root;

        while (node != null) {
            if (node.val == val) {
                return node;
            }

            if (val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    /**
     * Solution: Recursion
     * - Time: O(h)
     * - Space: O(h)
     * where h is the height of the tree, O(n) worst case
     */
    public TreeNode searchBSTV1(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBSTV1(root.left, val);
        }
        return searchBSTV1(root.right, val);
    }
}
