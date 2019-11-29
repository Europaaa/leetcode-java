package com.leetcode.medium.active;

/**
 * Copy List with Random Pointer
 * Link: https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public Node copyRandomList(Node head) {
        // Add the copies right next to the original nodes
        Node node = head;
        for (; node != null; node = node.next.next) {
            Node next = node.next;
            node.next = new Node(node.val);
            node.next.next = next;
        }

        // Link the random pointers between copies
        node = head;
        for (; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
        }

        // Restore the next pointers for the original nodes and link the copies
        Node dummyHead = new Node(0);

        node = head;
        Node newNode = dummyHead;
        for (; node != null; node = node.next) {
            newNode.next = node.next;
            newNode = newNode.next;

            node.next = node.next.next;
        }
        return dummyHead.next;
    }
}
