package com.leetcode.medium.active;

/**
 * Populating Next Right Pointers in Each Node
 * Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * Solution: Iterative
     * - Time: O(n)
     * - Space: O(1)
     */
    public Node connectV2(Node root) {
        Node left = root;
        while (left != null) {
            Node node = left;
            while (node != null) {
                if (node.left != null) {
                    node.left.next = node.right;
                }
                if (node.right != null && node.next != null) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            left = left.left;
        }
        return root;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(logn)
     */
    public Node connectV1(Node root) {
        if (root == null || root.left == null) {
            return root;
        }

        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        connectV1(root.left);
        connectV1(root.right);
        return root;
    }
}
