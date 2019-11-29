package com.leetcode.medium.archived;

import java.util.Stack;

/**
 * Decode String
 * Link: https://leetcode.com/problems/decode-string/
 */
public class DecodeString {

    /**
     * Solution:
     * - Time: O(nk)
     * - Space: O(nk)
     */
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 0) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                StringBuilder builder = new StringBuilder();

                for (; i < chars.length && Character.isDigit(chars[i]); i++) {
                    builder.append(chars[i]);
                }
                i--;

                stack.push(builder.toString());
            } else if (chars[i] == ']') {
                String token = "";
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    token = stack.pop() + token;
                }
                stack.pop();

                int k = Integer.valueOf(stack.pop());
                stack.push(repeat(token, k));
            } else {
                stack.push(String.valueOf(chars[i]));
            }
        }

        String result = "";
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }

    private String repeat(String s, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            builder.append(s);
        }
        return builder.toString();
    }
}
