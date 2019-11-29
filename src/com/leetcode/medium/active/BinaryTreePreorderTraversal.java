package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Preorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

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
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            values.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return values;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> preorderTraversalV1(TreeNode root) {
        if (root == null) {
            return Arrays.asList();
        }

        List<Integer> values = new ArrayList<>();
        values.add(root.val);
        values.addAll(preorderTraversalV1(root.left));
        values.addAll(preorderTraversalV1(root.right));
        return values;
    }
}
