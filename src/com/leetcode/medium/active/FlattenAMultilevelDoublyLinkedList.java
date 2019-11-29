package com.leetcode.medium.active;

import java.util.Stack;

/**
 * Flatten a Multilevel Doubly Linked List
 * Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 */
public class FlattenAMultilevelDoublyLinkedList {

    static class Node {
        int val;
        Node prev;
        Node next;
        Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public Node flattenV2(Node head) {
        flatLast(head);
        return head;
    }

    private Node flatLast(Node node) {
        if (node == null) {
            return null;
        }

        Node child = node.child;
        Node next = node.next;

        Node childLast = flatLast(child);
        Node nextLast = flatLast(next);

        node.child = null;
        if (childLast != null) {
            node.next = child;
            child.prev = node;
            node = childLast;
        }
        if (nextLast != null) {
            node.next = next;
            next.prev = node;
            node = nextLast;
        }
        return node;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public Node flattenV1(Node head) {
        Stack<Node> stack = new Stack<>();

        Node node = head;
        while (node != null) {
            if (node.child != null) {
                stack.push(node.next);

                node.next = node.child;
                if (node.next != null) {
                    node.next.prev = node;
                }

                node.child = null;
            } else if (node.next == null && !stack.isEmpty()) {
                node.next = stack.pop();
                if (node.next != null) {
                    node.next.prev = node;
                }
            }

            node = node.next;
        }
        return head;
    }
}
