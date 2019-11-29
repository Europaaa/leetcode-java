package com.leetcode.easy.archived;

import java.util.Stack;

/**
 * Valid Parentheses
 * Link: https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c1 : chars) {
            if (c1 == '(' || c1 == '{' || c1 == '[') {
                stack.push(c1);
                continue;
            }

            if (stack.isEmpty() || !isMatchingParentheses(stack.pop(), c1)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatchingParentheses(char c1, char c2) {
        switch (c1) {
            case '(':
                return c2 == ')';
            case '{':
                return c2 == '}';
            case '[':
                return c2 == ']';
            default:
                return false;
        }
    }
}
