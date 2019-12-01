package com.leetcode.easy.archived;

import java.util.Optional;

/**
 * Balanced Binary Tree
 * Link: https://leetcode.com/problems/balanced-binary-tree/
 */
public class BalancedBinaryTree {

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
     * - Time: O(h)
     * - Space: O(h)
     * where h is the height of the tree, O(logn) in worst case
     */
    public boolean isBalanced(TreeNode root) {
        Optional<Integer> height = getHeightIfBalanced(root);
        return height.isPresent();
    }

    private Optional<Integer> getHeightIfBalanced(TreeNode root) {
        if (root == null) {
            return Optional.of(0);
        }

        Optional<Integer> left = getHeightIfBalanced(root.left);
        Optional<Integer> right = getHeightIfBalanced(root.right);
        if (left.isPresent() && right.isPresent()) {
            if (Math.abs(left.get() - right.get()) <= 1) {
                return Optional.of(Math.max(left.get(), right.get()) + 1);
            }
        }
        return Optional.empty();
    }
}
