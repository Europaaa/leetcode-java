package com.leetcode.easy.active;

/**
 * Min Stack
 * Link: https://leetcode.com/problems/min-stack/
 */
public class MinStack {

    private ListNode head;

    public MinStack() {
    }

    public void push(int x) {
        int min = Integer.MAX_VALUE;
        if (this.head != null) {
            min = this.head.min;
        }

        ListNode node = new ListNode(x);
        node.next = this.head;
        node.min = Math.min(min, x);
        this.head = node;
    }

    public void pop() {
        this.head = this.head.next;
    }

    public int top() {
        return this.head.val;
    }

    public int getMin() {
        return this.head.min;
    }

    static class ListNode {
        int val;
        int min;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
