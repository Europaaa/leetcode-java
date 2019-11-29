package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Binary Search Tree Iterator
 * Link: https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BinarySearchTreeIterator {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class BSTIteratorV2 {

        private Stack<TreeNode> stack;

        public BSTIteratorV2(TreeNode root) {
            this.stack = new Stack<>();
            this.leftmostInOrder(root);
        }

        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        private void leftmostInOrder(TreeNode root) {
            TreeNode node = root;
            while (node != null) {
                this.stack.push(node);
                node = node.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            // Node at the top of the stack is the next smallest element
            TreeNode topmostNode = this.stack.pop();

            // Need to maintain the invariant. If the node has a right child, call the
            // helper function for the right child
            if (topmostNode.right != null) {
                this.leftmostInOrder(topmostNode.right);
            }
            return topmostNode.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !this.stack.isEmpty();
        }
    }

    class BSTIteratorV1 {

        private Iterator<Integer> iterator;

        public BSTIteratorV1(TreeNode root) {
            this.iterator = inorderTraversal(root).iterator();
        }

        public List<Integer> inorderTraversal(TreeNode root) {
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

        /** @return the next smallest number */
        public int next() {
            if (this.hasNext()) {
                return iterator.next();
            }
            throw new IllegalStateException();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}
