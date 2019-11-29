package com.leetcode.easy.archived;

/**
 * Reverse String
 * Link: https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
}
