package com.leetcode.easy.active;

import java.util.Stack;

/**
 * Split a String in Balanced Strings
 * Link: https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class SplitAStringInBalancedStrings {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int balancedStringSplitV2(String s) {
        char[] chars = s.toCharArray();

        int counters = 0;
        int pointer = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'L') {
                pointer++;
            } else {
                pointer--;
            }

            if (pointer == 0) {
                counters++;
            }
        }
        return counters;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int balancedStringSplitV1(String s) {
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        int counters = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && stack.peek() != chars[i]) {
                stack.pop();
            } else {
                stack.push(chars[i]);
            }

            if (stack.isEmpty()) {
                counters++;
            }
        }
        return counters;
    }
}
