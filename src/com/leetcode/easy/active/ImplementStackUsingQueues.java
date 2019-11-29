package com.leetcode.easy.active;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement Stack using Queues
 * Link: https://leetcode.com/problems/implement-stack-using-queues/
 */
public class ImplementStackUsingQueues {

    class MyStackV1 {

        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStackV1() {
            this.queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            this.queue.offer(x);
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            Queue<Integer> queue = new LinkedList<>();

            int size = this.queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.offer(this.queue.poll());
            }

            int x = this.queue.poll();
            this.queue = queue;
            return x;
        }

        /** Get the top element. */
        public int top() {
            Queue<Integer> queue = new LinkedList<>();

            int size = this.queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.offer(this.queue.poll());
            }

            int x = this.queue.peek();
            queue.offer(x);

            this.queue = queue;
            return x;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }

    class MyStackV2 {

        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStackV2() {
            this.queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(x);

            while (!this.queue.isEmpty()) {
                queue.offer(this.queue.poll());
            }

            this.queue = queue;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return this.queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return this.queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }

    class MyStackV3 {

        private Queue<Integer> queue;

        /** Initialize your data structure here. */
        public MyStackV3() {
            this.queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            int size = this.queue.size();

            this.queue.offer(x);
            for (int i = 0; i < size; i++) {
                this.queue.offer(this.queue.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return this.queue.poll();
        }

        /** Get the top element. */
        public int top() {
            return this.queue.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.queue.isEmpty();
        }
    }
}
