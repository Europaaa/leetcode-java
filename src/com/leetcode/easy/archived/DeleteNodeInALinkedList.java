package com.leetcode.easy.archived;

/**
 * Delete Node in a Linked List
 * Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class DeleteNodeInALinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution:
     * - Time: O(1)
     * - Space: O(1)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
