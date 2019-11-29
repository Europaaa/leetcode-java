package com.leetcode.medium.active;

/**
 * Rotate List
 * Link: https://leetcode.com/problems/rotate-list/
 */
public class RotateList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // Find out the length of the list
        int n = 0;
        ListNode node = head;
        for (; node != null; node = node.next, n++) {
        }

        // Find the number of places to rotate
        int m = k % n;
        if (m == 0) {
            return head;
        }

        ListNode node1 = head;
        for (int i = 0; i < m; i++) {
            node1 = node1.next;
        }

        ListNode node2 = head;
        for (; node1.next != null; node1 = node1.next, node2 = node2.next) {
        }

        ListNode newHead = node2.next;
        node2.next = null;
        node1.next = head;

        return newHead;
    }
}
