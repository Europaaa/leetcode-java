package com.leetcode.medium.archived;

/**
 * Add Two Numbers
 * Link: https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l1;
        }
        if (l2 == null) {
            return l2;
        }

        ListNode node1 = l1;
        ListNode node2 = l2;

        ListNode dummyHead = new ListNode(0);
        ListNode node = dummyHead;

        int advance = 0;
        for (; node1 != null || node2 != null;) {
            int v1 = node1 == null ? 0 : node1.val;
            int v2 = node2 == null ? 0 : node2.val;

            int v = v1 + v2 + advance;
            advance = v / 10;

            node.next = new ListNode(v % 10);

            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
            node = node.next;
        }

        if (advance == 1) {
            node.next = new ListNode(1);
        }
        return dummyHead.next;
    }
}
