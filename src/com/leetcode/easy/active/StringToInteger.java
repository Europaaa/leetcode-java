package com.leetcode.easy.active;

/**
 * String to Integer (atoi)
 * Link: https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();

        int i = 0;
        for (; i < chars.length && chars[i] == ' '; i++) {
        }

        char sign = '+';
        if (i < chars.length && (chars[i] == '+' || chars[i] == '-')) {
            sign = chars[i++];
        }

        int start = i;
        int end = i;
        for (; i < chars.length && chars[i] >= '0' && chars[i] <= '9'; i++, end++) {
        }

        int value = 0;
        for (int j = start; j < end; j++) {
            if (value > Integer.MAX_VALUE / 10 || (value == Integer.MAX_VALUE / 10 && (chars[j] - '0' > Integer.MAX_VALUE % 10))) {
                return sign == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            value = value * 10 + (chars[j] - '0');
        }
        return sign == '+' ? value : -1 * value;
    }
}
