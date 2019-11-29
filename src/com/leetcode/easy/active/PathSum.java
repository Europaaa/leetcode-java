package com.leetcode.easy.active;

import java.util.Stack;

/**
 * Path Sum
 * Link: https://leetcode.com/problems/path-sum/
 */
public class PathSum {

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
    public boolean hasPathSumV2(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();

        stack.push(root);
        sums.push(sum);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int target = sums.pop();

            if (node.left == null && node.right == null && node.val == target) {
                return true;
            }
            if (node.right != null) {
                stack.push(node.right);
                sums.push(target - node.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                sums.push(target - node.val);
            }

        }
        return false;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public boolean hasPathSumV1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }
        return hasPathSumV1(root.left, sum - root.val) || hasPathSumV1(root.right, sum - root.val);
    }
}
