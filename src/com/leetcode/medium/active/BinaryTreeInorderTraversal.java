package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Inorder Traversal
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Solution: Morris Traversal
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> inorderTraversalV3(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                values.add(node.val);
                node = node.right;
            } else {
                TreeNode pre = node.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = node;

                TreeNode temp = node;
                node = node.left;
                temp.left = null;
            }
        }
        return values;
    }

    /**
     * Solution: Iterative
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            values.add(node.val);
            node = node.right;
        }
        return values;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> inorderTraversalV1(TreeNode root) {
        if (root == null) {
            return Arrays.asList();
        }

        List<Integer> values = new ArrayList<>();
        values.addAll(inorderTraversalV1(root.left));
        values.add(root.val);
        values.addAll(inorderTraversalV1(root.right));
        return values;
    }
}
