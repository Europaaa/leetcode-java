package com.leetcode.easy.archived;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * N-ary Tree Preorder Traversal
 * Link: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class NaryTreePreorderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    /**
     * Solution: Iterative
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> preorderV2(Node root) {
        List<Integer> values = new ArrayList<>();

        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            values.add(node.val);

            int size = node.children.size();
            for (int i = 0; i < size; i++) {
                stack.push(node.children.get(size - i - 1));
            }
        }
        return values;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> preorderV1(Node root) {
        if (root == null) {
            return Arrays.asList();
        }

        List<Integer> values = new ArrayList<>();
        values.add(root.val);
        for (Node child : root.children) {
            values.addAll(preorderV1(child));
        }
        return values;
    }
}
