package com.leetcode.easy.archived;

import java.util.HashMap;
import java.util.Map;

/**
 * Valid Anagram
 * Link: https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1), as the hash table size stays constant
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> counters1 = countChars(s);
        Map<Character, Integer> counters2 = countChars(t);

        if (counters1.size() == counters2.size()) {
            for (Character c : counters1.keySet()) {
                if (!counters1.get(c).equals(counters2.getOrDefault(c, 0))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private Map<Character, Integer> countChars(String s) {
        char[] chars = s.toCharArray();

        Map<Character, Integer> counters = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            counters.put(chars[i], counters.getOrDefault(chars[i], 0) + 1);
        }
        return counters;
    }
}
