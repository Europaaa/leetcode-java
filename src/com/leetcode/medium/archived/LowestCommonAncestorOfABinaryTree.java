package com.leetcode.medium.archived;

import java.util.ArrayList;
import java.util.List;

/**
 * Lowest Common Ancestor of a Binary Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {

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
     * - Space: O(n)
     */
    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);

        TreeNode ancestor = null;

        int size = Math.min(path1.size(), path2.size());
        for (int i = 0; i < size; i++) {
            TreeNode node1 = path1.get(path1.size() - i - 1);
            TreeNode node2 = path2.get(path2.size() - i - 1);

            if (!node1.equals(node2)) {
                return ancestor;
            }
            ancestor = node1;
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode node) {
        if (root == null) {
            return null;
        }
        if (root.equals(node)) {
            List<TreeNode> path = new ArrayList<>();
            path.add(root);
            return path;
        }

        List<TreeNode> path = getPath(root.left, node);
        if (path == null) {
            path = getPath(root.right, node);
        }
        if (path == null) {
            return null;
        }
        path.add(root);
        return path;
    }
}
