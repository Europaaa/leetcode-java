package com.leetcode.medium.archived;

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 * Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        int v1, v2;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 + v1);
                    break;
                case "-":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 - v1);
                    break;
                case "*":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 * v1);
                    break;
                case "/":
                    v1 = stack.pop();
                    v2 = stack.pop();
                    stack.push(v2 / v1);
                    break;
                default:
                    stack.push(Integer.valueOf(tokens[i]));
                    break;
            }
        }
        return stack.pop();
    }
}
