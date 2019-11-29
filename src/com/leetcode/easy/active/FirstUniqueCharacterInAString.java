package com.leetcode.easy.active;

import java.util.HashMap;
import java.util.Map;

/**
 * First Unique Character in a String
 * Link: https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInAString {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1), as the hash table size stays constant
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> counters = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            counters.put(chars[i], counters.getOrDefault(chars[i], 0) + 1);
        }

        for (int i = 0; i < chars.length; i++) {
            if (counters.getOrDefault(chars[i], 0) == 1) {
                return i;
            }
        }
        return -1;
    }
}
