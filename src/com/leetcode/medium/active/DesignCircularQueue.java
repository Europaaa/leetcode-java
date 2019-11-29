package com.leetcode.medium.active;

/**
 * Design Circular Queue
 * Link: https://leetcode.com/problems/design-circular-queue/
 */
public class DesignCircularQueue {

    private int[] values;
    private int head;
    private int tail;
    private int count;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public DesignCircularQueue(int k) {
        this.values = new int[k];
        this.head = 0;
        this.tail = -1;
        this.count = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        }
        this.tail = (this.tail + 1) % this.values.length;
        this.values[this.tail] = value;
        this.count++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        }
        this.head = (this.head + 1) % this.values.length;
        this.count--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.values[this.head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        }
        return this.values[this.tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return this.count == this.values.length;
    }
}
