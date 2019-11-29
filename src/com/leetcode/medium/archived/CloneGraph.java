package com.leetcode.medium.archived;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clone Graph
 * Link: https://leetcode.com/problems/clone-graph/
 */
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap<>());
    }

    private Node cloneGraph(Node node, Map<Node, Node> cloned) {
        if (cloned.containsKey(node)) {
            return cloned.get(node);
        }

        Node clone = new Node();
        clone.val = node.val;
        cloned.put(node, clone);

        clone.neighbors = node.neighbors.stream().map(neighbor -> cloneGraph(neighbor, cloned))
                .collect(Collectors.toList());
        return clone;
    }
}
