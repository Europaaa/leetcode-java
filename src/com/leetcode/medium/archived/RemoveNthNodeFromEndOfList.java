package com.leetcode.medium.archived;

/**
 * Remove Nth Node From End of List
 * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution: One Passes
     * - Time: O(n)
     * - Space: O(1)
     */
    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // node1 represents the pointer to the nth node from the end of the sublist
        // node2 represents the pointer to the end of sublist
        ListNode node1 = dummyHead;
        ListNode node2 = dummyHead;

        // Advance the node2 pointer to the n-th node from the start, including the dummy node
        for (int i = 0; i < n; i++) {
            node2 = node2.next;
        }

        // Move the two pointer together
        while (node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }

        ListNode next = node1.next;
        node1.next = next.next;
        next.next = null;

        return dummyHead.next;
    }

    /**
     * Solution: Two Passes
     * - Time: O(n)
     * - Space: O(1)
     */
    public ListNode removeNthFromEndV1(ListNode head, int n) {
        // Get the size of the linked list
        ListNode node = head;
        int size = 0;
        while (node.next != null) {
            size++;
            node = node.next;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // Find the (n-1)-th node from the end
        node = dummyHead;
        for (int i = 0; i <= size - n; i++, node = node.next) {
        }

        ListNode next = node.next;
        node.next = next.next;
        next.next = null;

        return dummyHead.next;
    }
}
