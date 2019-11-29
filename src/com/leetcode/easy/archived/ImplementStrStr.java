package com.leetcode.easy.archived;

/**
 * Implement strStr()
 * Link: https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(1)
     */
    public int strStr(String haystack, String needle) {
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        for (int i = 0; i < haystackChars.length - needleChars.length + 1; i++) {
            boolean match = true;
            for (int j = 0; match && j < needleChars.length; j++) {
                if (needleChars[j] != haystackChars[i + j]) {
                    match = false;
                }
            }

            if (match) {
                return i;
            }
        }
        return -1;
    }
}
