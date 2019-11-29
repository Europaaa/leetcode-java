package com.leetcode.easy.active;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Symmetric Tree
 * Link: https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {

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
     * - Space: O(1)
     */
    public boolean isSymmetricV2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) {
                continue;
            }

            if (node1 == null || node2 == null) {
                return false;
            }

            if (node1.val != node2.val) {
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }

        return true;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(1)
     */
    public boolean isSymmetricV1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
            }
            return false;
        }
        return false;
    }
}
