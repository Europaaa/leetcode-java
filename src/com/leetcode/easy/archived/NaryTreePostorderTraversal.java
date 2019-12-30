package com.leetcode.easy.archived;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * N-ary Tree Postorder Traversal
 * Link: https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class NaryTreePostorderTraversal {

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
    public List<Integer> postorderV2(Node root) {
        LinkedList<Integer> values = new LinkedList<>();

        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            values.addFirst(node.val);

            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return values;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> postorderV1(Node root) {
        if (root == null) {
            return Arrays.asList();
        }

        List<Integer> values = new ArrayList<>();
        for (Node child : root.children) {
            values.addAll(postorderV1(child));
        }
        values.add(root.val);
        return values;
    }
}
