package com.leetcode.easy.active;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Isomorphic Strings
 * Link: https://leetcode.com/problems/isomorphic-strings/
 */
public class IsomorphicStrings {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public boolean isIsomorphicV2(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        if (chars1.length != chars2.length) {
            return false;
        }

        Map<Character, Integer> indices1 = new HashMap<>();
        Map<Character, Integer> indices2 = new HashMap<>();
        for (int i = 0; i < chars1.length; i++) {
            int i1 = indices1.getOrDefault(chars1[i], -1);
            int i2 = indices2.getOrDefault(chars2[i], -1);

            if (i1 != i2) {
                return false;
            }
            indices1.put(chars1[i], i);
            indices2.put(chars2[i], i);
        }
        return true;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public boolean isIsomorphicV1(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        if (chars1.length != chars2.length) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < chars1.length; i++) {
            if (map.containsKey(chars1[i])) {
                if (map.get(chars1[i]) != chars2[i]) {
                    return false;
                }
            } else {
                if (set.contains(chars2[i])) {
                    return false;
                }
                map.put(chars1[i], chars2[i]);
                set.add(chars2[i]);
            }
        }
        return true;
    }
}
