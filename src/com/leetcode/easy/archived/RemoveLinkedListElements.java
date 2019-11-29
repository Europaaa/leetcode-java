package com.leetcode.easy.archived;

public class RemoveLinkedListElements {

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(val + 1);
        dummyHead.next = head;

        ListNode node = dummyHead;
        ListNode current = dummyHead.next;

        while (current != null) {
            if (current.val != val) {
                node.next = current;
                node = node.next;
            }
            current = current.next;
        }

        // Cut the tail
        node.next = null;

        return dummyHead.next;
    }
}
