package com.leetcode.easy.archived;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Jewels and Stones
 * Link: https://leetcode.com/problems/jewels-and-stones/
 */
public class JewelsAndStones {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int numJewelsInStonesV2(String J, String S) {
        Set<Character> jewels = new HashSet<>();

        char[] chars = J.toCharArray();
        for (char c : chars) {
            jewels.add(c);
        }

        char[] stones = S.toCharArray();

        int counter = 0;
        for (char c : stones) {
            if (jewels.contains(c)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int numJewelsInStonesV1(String J, String S) {
        Map<Character, Integer> counters = new HashMap<>();

        char[] jewels = J.toCharArray();
        for (char c : jewels) {
            counters.put(c, 0);
        }

        char[] stones = S.toCharArray();
        for (char c : stones) {
            if (counters.containsKey(c)) {
                counters.put(c, counters.get(c) + 1);
            }
        }
        return counters.values().stream().mapToInt(c -> c).sum();
    }
}
