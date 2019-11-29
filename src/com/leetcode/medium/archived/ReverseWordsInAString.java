package com.leetcode.medium.archived;

import java.util.LinkedList;

/**
 * Reverse Words in a String
 * Link: https://leetcode.com/problems/reverse-words-in-a-string/
 */
public class ReverseWordsInAString {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        LinkedList<String> words = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                continue;
            }

            StringBuilder builder = new StringBuilder();
            for (; i < chars.length && chars[i] != ' '; i++) {
                builder.append(chars[i]);
            }
            words.addFirst(builder.toString());
        }

        StringBuilder builder = new StringBuilder();
        while (!words.isEmpty()) {
            builder.append(words.pop());
            builder.append(' ');
        }
        return builder.toString().trim();
    }
}
