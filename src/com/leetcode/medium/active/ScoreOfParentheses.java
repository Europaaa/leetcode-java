package com.leetcode.medium.active;

import java.util.Stack;

/**
 * Score of Parentheses
 * Link: https://leetcode.com/problems/score-of-parentheses/
 */
public class ScoreOfParentheses {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int scoreOfParenthesesV2(String S) {
        int scores = 0;

        char[] chars = S.toCharArray();
        for (int i = 0, j = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                j++;
            } else {
                j--;
            }

            if (chars[i] == ')' && chars[i - 1] == '(') {
                scores += Math.pow(2, j);
            }
        }
        return scores;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int scoreOfParenthesesV1(String S) {
        char[] chars = S.toCharArray();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(0);
                continue;
            }

            int score = stack.pop();
            if (score == 0) {
                stack.push(1);
                continue;
            }

            while (stack.peek() != 0) {
                score += stack.pop();
            }
            stack.pop();
            stack.push(2 * score);
        }

        int scores = 0;
        while (!stack.isEmpty()) {
            scores += stack.pop();
        }
        return scores;
    }
}
