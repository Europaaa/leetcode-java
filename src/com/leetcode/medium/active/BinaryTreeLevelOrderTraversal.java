package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal
 * Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();

        if (root == null) {
            return nodes;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            nodes.add(level);
        }
        return nodes;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<List<Integer>> levelOrderV1(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        levelOrder(root, nodes, 0);
        return nodes;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> nodes, int level) {
        if (root == null) {
            return;
        }

        if (level >= nodes.size()) {
            nodes.add(new ArrayList<>());
        }

        nodes.get(level).add(root.val);

        levelOrder(root.left, nodes, level + 1);
        levelOrder(root.right, nodes, level + 1);
    }
}
