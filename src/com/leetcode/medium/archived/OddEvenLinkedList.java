package com.leetcode.medium.archived;

/**
 * Odd Even Linked List
 * Link: https://leetcode.com/problems/odd-even-linked-list/
 */
public class OddEvenLinkedList {

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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = new ListNode(0);
        ListNode oddHead = new ListNode(0);

        ListNode evenNode = evenHead;
        ListNode oddNode = oddHead;

        int i = 1;
        ListNode node = head;
        while (node != null) {
            if (i % 2 == 0) {
                evenNode.next = node;
                evenNode = evenNode.next;
            } else {
                oddNode.next = node;
                oddNode = oddNode.next;
            }
            i++;
            node = node.next;
        }

        oddNode.next = evenHead.next;
        evenNode.next = null;
        return oddHead.next;
    }

}
