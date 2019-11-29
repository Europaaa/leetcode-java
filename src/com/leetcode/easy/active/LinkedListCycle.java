package com.leetcode.easy.active;

import java.util.HashSet;
import java.util.Set;

/**
 * Linked List Cycle
 * Link: https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Solution: Two Pointers
     * - Time: O(n)
     * - Space: O(1)
     */
    public boolean hasCycleV2(ListNode head) {
        // node1 is the slow pointer and node2 is the fast pointer
        ListNode node1 = head;
        ListNode node2 = head.next;

        while (node1 != node2) {
            if (node2 == null || node2.next == null) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return true;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public boolean hasCycleV1(ListNode head) {
        Set<ListNode> duplicates = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (duplicates.contains(node)) {
                return true;
            }
            duplicates.add(node);
            node = node.next;
        }
        return false;
    }
}
