package com.leetcode.easy.archived;

/**
 * Convert Binary Number in a Linked List to Integer
 * Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class ConvertBinaryNumberInALinkedListToInteger {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int getDecimalValue(ListNode head) {
        int value = 0;

        ListNode node = head;
        while (node != null) {
            value = value * 2 + node.val;
            node = node.next;
        }
        return value;
    }
}
