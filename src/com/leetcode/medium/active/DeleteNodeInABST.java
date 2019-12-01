package com.leetcode.medium.active;

/**
 * Delete Node in a BST
 * Link: https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInABST {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val < root.val) {
            root.left = deleteNode(root.left, val);
        } else if (root.val < val) {
            root.right = deleteNode(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            TreeNode minNode = findMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }

    private TreeNode findMinNode(TreeNode root) {
        TreeNode node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
