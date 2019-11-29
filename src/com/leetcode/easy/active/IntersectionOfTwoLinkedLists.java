package com.leetcode.easy.active;

/**
 * Intersection of Two Linked Lists
 * Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {

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
    public ListNode getIntersectionNodeV3(ListNode headA, ListNode headB) {
        if (headA == null || headB  == null) {
            return null;
        }

        // Find the tail node for list A
        ListNode node = headA;
        for (; node.next != null; node = node.next) {
        }

        node.next = headB;

        // Create a cycle and find the intersection
        ListNode intersection = detectCycle(headA);

        // Restore the original state
        node.next = null;
        return intersection;
    }

    private ListNode detectCycle(ListNode head) {
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

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        boolean connectedA = false;
        boolean connectedB = false;
        while (!nodeA.equals(nodeB)) {
            if (nodeA.next == null) {
                if (connectedA) {
                    return null;
                }
                connectedA = true;
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }

            if (nodeB.next == null) {
                if (connectedB) {
                    return null;
                }
                connectedB = true;
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(1)
     */
    public ListNode getIntersectionNodeV1(ListNode headA, ListNode headB) {
        ListNode node1 = headA;
        while (node1 != null) {
            ListNode node2 = headB;
            while (node2 != null && !node1.equals(node2)) {
                node2 = node2.next;
            }
            if (node1.equals(node2)) {
                return node1;
            }
            node1 = node1.next;
        }
        return null;
    }
}
