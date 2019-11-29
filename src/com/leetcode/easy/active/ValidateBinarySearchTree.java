package com.leetcode.easy.active;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Validate Binary Search Tree
 * Link: https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Solution: In-Order Traversal
     * - Time: O(n)
     * - Space: O(n)
     */
    public boolean isValidBSTV2(TreeNode root) {
        List<TreeNode> tree = traverse(root);

        for (int i = 0; i < tree.size() - 1; i++) {
            if (tree.get(i).val >= tree.get(i + 1).val) {
                return false;
            }
        }
        return true;
    }

    private List<TreeNode> traverse(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> subtree1 = traverse(root.left);
        List<TreeNode> subtree2 = traverse(root.right);

        List<TreeNode> tree = new ArrayList<>();
        tree.addAll(subtree1);
        tree.add(root);
        tree.addAll(subtree2);

        return tree;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(1)
     */
    public boolean isValidBSTV1(TreeNode root) {
        return isValidBST(root, Optional.empty(), Optional.empty());
    }

    private boolean isValidBST(TreeNode root, Optional<Integer> min, Optional<Integer> max) {
        if (root == null) {
            return true;
        }

        if (min.isPresent() && min.get() >= root.val) {
            return false;
        }
        if (max.isPresent() && max.get() <= root.val) {
            return false;
        }

        if (!isValidBST(root.left, min, Optional.of(root.val))) {
            return false;
        }
        if (!isValidBST(root.right, Optional.of(root.val), max)) {
            return false;
        }
        return true;
    }
}
