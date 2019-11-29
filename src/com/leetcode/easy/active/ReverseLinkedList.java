package com.leetcode.easy.active;

/**
 * Reverse Linked List
 * Link: https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(n)
     */
    public ListNode reverseListV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = reverseListV2(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    /**
     * Solution: Iterative
     * - Time: O(n)
     * - Space: O(1)
     */
    public ListNode reverseListV1(ListNode head) {
        ListNode newHead = null;

        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
        }

        return newHead;
    }
}