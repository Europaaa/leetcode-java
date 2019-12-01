package com.leetcode.easy.archived;

import java.util.Stack;

/**
 * Same Tree
 * Link: https://leetcode.com/problems/same-tree/
 */
public class SameTree {

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
    public boolean isSameTreeV2(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(p);
        stack2.push(q);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();

            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            stack1.push(node1.left);
            stack1.push(node1.right);

            stack2.push(node2.left);
            stack2.push(node2.right);
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(h)
     * where h is the height of the tree, O(n) in worst case
     */
    public boolean isSameTreeV1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTreeV1(p.left, q.left) && isSameTreeV1(p.right, q.right);
    }
}
