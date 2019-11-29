package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

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
    public List<Integer> postorderTraversalV2(TreeNode root) {
        LinkedList<Integer> values = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            values.addFirst(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return values;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> postorderTraversalV1(TreeNode root) {
        if (root == null) {
            return Arrays.asList();
        }

        List<Integer> values = new ArrayList<>();
        values.addAll(postorderTraversalV1(root.left));
        values.addAll(postorderTraversalV1(root.right));
        values.add(root.val);
        return values;
    }
}
