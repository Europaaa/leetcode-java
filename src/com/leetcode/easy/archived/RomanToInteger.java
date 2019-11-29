package com.leetcode.easy.archived;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Integer
 * Link: https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    private static final Map<Character, Integer> MAPPING = new HashMap<>();

    {
        MAPPING.put('I', 1);
        MAPPING.put('V', 5);
        MAPPING.put('X', 10);
        MAPPING.put('L', 50);
        MAPPING.put('C', 100);
        MAPPING.put('D', 500);
        MAPPING.put('M', 1000);
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        int value = 0;
        for (int i = n - 1; i >= 0; ) {
            int v = MAPPING.get(chars[i--]);
            value += v;
            for (; i >= 0 && MAPPING.get(chars[i]) < v; i--) {
                value -= MAPPING.get(chars[i]);
            }
        }
        return value;
    }
}
