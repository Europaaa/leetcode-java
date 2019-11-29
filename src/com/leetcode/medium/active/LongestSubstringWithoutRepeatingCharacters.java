package com.leetcode.medium.active;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        if (n == 0) {
            return 0;
        }

        int length = 1;
        int maxLength = 1;

        Map<Character, Integer> indices = new HashMap<>();
        indices.put(chars[0], 0);

        for (int i = 1; i < n; i++) {
            length = Math.min(i - indices.getOrDefault(chars[i], -1), length + 1);
            maxLength = Math.max(length, maxLength);

            indices.put(chars[i], i);
        }
        return maxLength;
    }
}
