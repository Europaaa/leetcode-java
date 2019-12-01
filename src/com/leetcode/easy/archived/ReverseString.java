package com.leetcode.easy.archived;

/**
 * Reverse String
 * Link: https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    /**
     * Solution: Recursion
     * - Time: O(n)
     * - Space: O(n)
     */
    public void reverseStringV2(char[] s) {
        reverseString(s, 0, s.length - 1);
    }

    private void reverseString(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }

        char c = s[start];
        s[start] = s[end];
        s[end] = c;

        reverseString(s, start + 1, end - 1);
    }

    /**
     * Solution: Iterative
     * - Time: O(n)
     * - Space: O(1)
     */
    public void reverseStringV1(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
}
