package com.leetcode.easy.archived;

import java.util.LinkedList;

/**
 * Invert Binary Tree
 * Link: https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {

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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = right;
            node.right = left;

            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            }
        }
        return root;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public TreeNode invertTreeV1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode node = new TreeNode(root.val);
        node.right = invertTreeV1(root.left);
        node.left = invertTreeV1(root.right);
        return node;
    }
}
