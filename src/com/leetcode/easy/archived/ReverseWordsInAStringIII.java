package com.leetcode.easy.archived;

/**
 * Reverse Words in a String III
 * Link: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInAStringIII {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }

            StringBuilder wordBuilder = new StringBuilder();
            for (; i < chars.length && chars[i] != ' '; i++) {
                wordBuilder.append(chars[i]);
            }

            stringBuilder.append(wordBuilder.reverse().toString());
            stringBuilder.append(' ');
        }
        return stringBuilder.toString().trim();
    }
}

