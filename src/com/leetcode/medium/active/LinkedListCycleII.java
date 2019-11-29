package com.leetcode.medium.active;

/**
 * Linked List Cycle II
 * Link: https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution: Two Pointers (https://cs.stackexchange.com/a/45540)
     * - Time: O(n)
     * - Space: O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        // node1 is the slow pointer and node2 is the fast pointer
        ListNode node1 = head.next;
        ListNode node2 = head.next.next;

        while (node1 != node2) {
            if (node2 == null || node2.next == null) {
                return null;
            }
            node1 = node1.next;
            node2 = node2.next.next;
        }

        ListNode node3 = head;
        while (node1 != node3) {
            node1 = node1.next;
            node3 = node3.next;
        }
        return node1;
    }
}
