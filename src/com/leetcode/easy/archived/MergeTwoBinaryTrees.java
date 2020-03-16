package com.leetcode.easy.archived;

import java.util.Stack;

/**
 * Merge Two Binary Trees
 * Link: https://leetcode.com/problems/merge-two-binary-trees/
 */
public class MergeTwoBinaryTrees {

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
    public TreeNode mergeTreesV2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root1);

        Stack<TreeNode> stack2 = new Stack<>();
        stack2.push(root2);

        Stack<TreeNode> stack = new Stack<>();

        // Create a dummy root
        TreeNode root = new TreeNode(0);
        stack.push(root);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            TreeNode node = stack.pop();

            if (node1 == null || node2 == null || node == null) {
                continue;
            }

            node.val = node1.val + node2.val;

            if (node1.left == null) {
                node.left = node2.left;
            } else if (node2.left == null) {
                node.left = node1.left;
            } else {
                node.left = new TreeNode(0);

                stack1.push(node1.left);
                stack2.push(node2.left);
                stack.push(node.left);
            }

            if (node1.right == null) {
                node.right = node2.right;
            } else if (node2.right == null) {
                node.right = node1.right;
            } else {
                node.right = new TreeNode(0);

                stack1.push(node1.right);
                stack2.push(node2.right);
                stack.push(node.right);
            }
        }
        return root;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public TreeNode mergeTreesV1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTreesV1(root1.left, root2.left);
        root.right = mergeTreesV1(root1.right, root2.right);
        return root;
    }
}
