package com.leetcode.easy.archived;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Maximum Depth of N-ary Tree
 * Link: https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaximumDepthOfNaryTree {

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
     * Solution:
     * - Time: O(n)
     * - Space: O(h)
     * where h is the height of the tree, O(n) in worst case
     */
    public int maxDepthV2(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }

            depth++;
        }
        return depth;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(h)
     * where h is the height of the tree, O(n) in worst case
     */
    public int maxDepthV1(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = root.children.stream().mapToInt(this::maxDepthV1).max().orElse(0);
        return maxDepth + 1;
    }
}
