package com.leetcode.easy.archived;

/**
 * Valid Palindrome
 * Link: https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();

        for (int i = 0, j = chars.length - 1; i < j;) {
            if (!isValidChar(chars[i])) {
                i++;
                continue;
            }

            if (!isValidChar(chars[j])) {
                j--;
                continue;
            }

            if (chars[i] != chars[j]) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    private boolean isValidChar(char c) {
        if ('0' <= c && c <= '9') {
            return true;
        }
        if ('a' <= c && c <= 'z') {
            return true;
        }
        return false;
    }
}
