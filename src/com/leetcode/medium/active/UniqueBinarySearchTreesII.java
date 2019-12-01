package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 * Link: https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class UniqueBinarySearchTreesII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTreesV2(int n) {
        List<TreeNode>[] memo = new List[n + 1];
        memo[0] = new ArrayList<>();

        if (n == 0) {
            return new ArrayList<>();
        }

        for (int size = 1; size <= n; size++) {
            memo[size] = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                for (TreeNode left : memo[i]) {
                    for (TreeNode right : memo[size - i - 1]) {
                        TreeNode node = new TreeNode(i + 1);
                        node.left = left;
                        node.right = clone(right, i + 1);
                        memo[size].add(node);
                    }
                }
            }
        }
        return memo[n];
    }

    private TreeNode clone(TreeNode node, int offset) {
        if (node == null) {
            return null;
        }

        TreeNode clone = new TreeNode(node.val + offset);
        clone.left = clone(node.left, offset);
        clone.right = clone(node.right, offset);
        return clone;
    }

    public List<TreeNode> generateTreesV1(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    nodes.add(root);
                }
            }
        }
        return nodes;
    }
}
