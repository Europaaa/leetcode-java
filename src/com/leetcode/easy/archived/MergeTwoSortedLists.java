package com.leetcode.easy.archived;

/**
 * Merge Two Sorted Lists
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode node1 = head1;
        ListNode node2 = head2;

        ListNode dummyHead = new ListNode(0);

        ListNode node = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                node.next = node1;
                node1 = node1.next;
            } else {
                node.next = node2;
                node2 = node2.next;
            }

            node = node.next;
        }

        while (node1 != null) {
            node.next = node1;
            node1 = node1.next;
            node = node.next;
        }

        while (node2 != null) {
            node.next = node2;
            node2 = node2.next;
            node = node.next;
        }

        return dummyHead.next;
    }
}
