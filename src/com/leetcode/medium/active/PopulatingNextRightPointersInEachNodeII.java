package com.leetcode.medium.active;

/**
 * Populating Next Right Pointers in Each Node II
 * Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

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
        Node node = root;
        while (node != null) {
            Node dummyHead = new Node(0);
            Node current = dummyHead;
            while (node != null) {
                if (node.left != null) {
                    current.next = node.left;
                    current = current.next;
                }
                if (node.right != null) {
                    current.next = node.right;
                    current = current.next;
                }
                node = node.next;
            }
            node = dummyHead.next;
        }
        return root;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(logn)
     */
    public Node connectV1(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            if (root.right == null) {
                root.left.next = getNext(root.next);
            } else {
                root.left.next = root.right;
            }
        }

        if (root.right != null) {
            root.right.next = getNext(root.next);
        }

        connectV1(root.right);
        connectV1(root.left);
        return root;
    }

    private Node getNext(Node root) {
        Node node = root;
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return node.left;
        }
        if (node.right != null) {
            return node.right;
        }
        return getNext(root.next);
    }
}
