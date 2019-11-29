package com.leetcode.easy.archived;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Common Prefix
 * Link: https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     * where s is the total number of chars in all strings
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        List<char[]> characters = new ArrayList<>();
        for (String s : strs) {
            characters.add(s.toCharArray());
        }

        char[] baseChars = characters.get(0);

        for (int i = 0; i < baseChars.length; i++) {
            char c = baseChars[i];

            for (char[] chars : characters) {
                if (i >= chars.length || chars[i] != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
