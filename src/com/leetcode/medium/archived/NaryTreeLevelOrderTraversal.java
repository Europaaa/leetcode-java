package com.leetcode.medium.archived;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N-ary Tree Level Order Traversal
 * Link: https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 */
public class NaryTreeLevelOrderTraversal {

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
    public List<List<Integer>> levelOrderV2(Node root) {
        List<List<Integer>> nodes = new ArrayList<>();

        if (root == null) {
            return nodes;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);

                for (Node child : node.children) {
                    queue.offer(child);
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
    public List<List<Integer>> levelOrderV1(Node root) {
        List<List<Integer>> nodes = new ArrayList<>();
        levelOrder(root, nodes, 0);
        return nodes;
    }

    private void levelOrder(Node root, List<List<Integer>> nodes, int level) {
        if (root == null) {
            return;
        }

        if (level >= nodes.size()) {
            nodes.add(new ArrayList<>());
        }

        nodes.get(level).add(root.val);

        for (Node child : root.children) {
            levelOrder(child, nodes, level + 1);
        }
    }
}
