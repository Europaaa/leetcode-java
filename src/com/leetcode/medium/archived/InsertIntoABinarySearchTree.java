package com.leetcode.medium.archived;

/**
 * Insert into a Binary Search Tree
 * Link: https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoABinarySearchTree {

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
    public TreeNode insertIntoBSTV2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode node = root;
        while (true) {
            if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                }
                node = node.right;
            }
        }
        return root;
    }

    /**
     * Solution: Recursion
     * - Time: O(h)
     * - Space: O(h)
     * where h is the height of the tree, O(n) worst case
     */
    public TreeNode insertIntoBSTV1(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBSTV1(root.left, val);
            return root;
        }
        root.right =  insertIntoBSTV1(root.right, val);
        return root;
    }
}
