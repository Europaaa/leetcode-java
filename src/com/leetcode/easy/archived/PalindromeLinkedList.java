package com.leetcode.easy.archived;

/**
 * Palindrome Linked List
 * Link: https://leetcode.com/problems/palindrome-linked-list/
 */
public class PalindromeLinkedList {

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
     * - Space: O(n)
     */
    public boolean isPalindrome(ListNode head) {
        // Make a copy of the list nodes
        ListNode newDummyHead = new ListNode(0);

        ListNode newNode = newDummyHead;
        for (ListNode node = head; node != null; node = node.next) {
            newNode.next = new ListNode(node.val);
            newNode = newNode.next;
        }

        // Reverse the list
        ListNode reversedList = reverseList(newDummyHead.next);

        // Compare
        for (ListNode node1 = head, node2 = reversedList; node1 != null && node2 != null; node1 = node1.next, node2 = node2.next) {
            if (node1.val != node2.val) {
                return false;
            }
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
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
