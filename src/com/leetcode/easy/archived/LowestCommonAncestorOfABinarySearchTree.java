package com.leetcode.easy.archived;

/**
 * Lowest Common Ancestor of a Binary Search Tree
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorOfABinarySearchTree {

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
     * - Time: O(h)
     * - Space: O(1)
     * where h is the height of the tree, O(n) in worst case
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode ancestor = root;
        while ((p.val < ancestor.val && q.val < ancestor.val) || (p.val > ancestor.val && q.val > ancestor.val)) {
            if (p.val < ancestor.val) {
                ancestor = ancestor.left;
            } else {
                ancestor = ancestor.right;
            }
        }
        return ancestor;
    }

    /**
     * Solution:
     * - Time: O(h)
     * - Space: O(h)
     * where h is the height of the tree, O(n) in worst case
     */
    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorV1(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorV1(root.right, p, q);
        }
        return root;
    }
}
