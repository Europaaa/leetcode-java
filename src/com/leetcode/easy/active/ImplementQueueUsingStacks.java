package com.leetcode.easy.active;

import java.util.Stack;

/**
 * Implement Queue using Stacks
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class ImplementQueueUsingStacks {

    class MyQueueV1 {

        private Stack<Integer> stack;

        /** Initialize your data structure here. */
        public MyQueueV1() {
            this.stack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            Stack<Integer> stack = new Stack<>();

            while (!this.stack.isEmpty()) {
                stack.push(this.stack.pop());
            }
            stack.push(x);

            while (!stack.isEmpty()) {
                this.stack.push(stack.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return this.stack.pop();
        }

        /** Get the front element. */
        public int peek() {
            return this.stack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return this.stack.isEmpty();
        }
    }

    class MyQueueV2 {

        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        /** Initialize your data structure here. */
        public MyQueueV2() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            this.stack1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if (this.stack2.isEmpty()) {
                this.moveStacks();
            }
            return this.stack2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (this.stack2.isEmpty()) {
                this.moveStacks();
            }
            return this.stack2.peek();
        }

        private void moveStacks() {
            while (!this.stack1.isEmpty()) {
                this.stack2.push(this.stack1.pop());
            }
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return this.stack1.isEmpty() && this.stack2.isEmpty();
        }
    }
}
