package com.leetcode.medium.archived;

/**
 * Swap Nodes in Pairs
 * Link: https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution: Iterative
     * - Time: O(n)
     * - Space: O(1)
     */
    public ListNode swapPairsV2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode parent = dummyHead;
        ListNode node = head;

        while (node != null && node.next != null) {
            ListNode next = node.next.next;
            parent.next = node.next;
            parent.next.next = node;
            node.next = next;

            parent = parent.next.next;
            node = next;
        }
        return dummyHead;
    }

    /**
     * Solution: Recursive
     * - Time: O(n)
     * - Space: O(n)
     */
    public ListNode swapPairsV1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next;
        ListNode next = head.next.next;
        node.next = head;
        head.next = swapPairsV1(next);
        return node;
    }
}
