package com.leetcode.medium.archived;

/**
 * Design Linked List
 * Link: https://leetcode.com/problems/design-linked-list/
 */
public class DesignLinkedList {

    static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private ListNode head;


    /**
     * Solution:
     * - Time:
     * -- get(index): O(n)
     * -- addAtHead(val): O(1)
     * -- addAtTail(val): O(n)
     * -- addAtIndex(index, val): O(n)
     * -- deleteAtIndex(index): O(n)
     * - Space:
     * -- get(index): O(1)
     * -- addAtHead(val): O(1)
     * -- addAtTail(val): O(1)
     * -- addAtIndex(index, val): O(1)
     * -- deleteAtIndex(index): O(1)
     */
    public DesignLinkedList() {
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        ListNode node = this.head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node == null ? -1 : node.value;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode head = new ListNode(val);
        head.next = this.head;
        this.head = head;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (this.head == null) {
            this.addAtHead(val);
            return;
        }

        ListNode node = this.head;
        for (; node.next != null; node = node.next) {
        }
        node.next = new ListNode(val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            this.addAtHead(val);
            return;
        }

        ListNode node = this.head;
        for (int i = 0; i < index - 1 && node != null; i++) {
            node = node.next;
        }

        if (node == null) {
            return;
        }

        ListNode newNode = new ListNode(val);
        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index == 0) {
            this.head = this.head.next;
            return;
        }

        ListNode node = this.head;
        for (int i = 0; i < index - 1 && node != null; i++) {
            node = node.next;
        }

        if (node.next == null) {
            return;
        }
        node.next = node.next.next;
    }
}
