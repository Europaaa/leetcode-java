package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Group Anagrams
 * Link: https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    /**
     * Solution:
     * - Time: O(nk)
     * - Space: O(nk)
     * where k is the maximum length of a string
     */
    public List<List<String>> groupAnagramsV2(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String key = getKeyV2(str);

            List<String> anagrams = groups.getOrDefault(key, new ArrayList<>());
            anagrams.add(str);
            groups.put(key, anagrams);
        }
        return groups.values().stream().collect(Collectors.toList());
    }

    private String getKeyV2(String str) {
        char[] chars = str.toCharArray();

        Map<Character, Integer> counters = new HashMap<>();
        for (char c : chars) {
            counters.put(c, counters.getOrDefault(c, 0) + 1);
        }

        StringBuilder builder = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            builder.append(counters.getOrDefault(c, 0));
        }
        return builder.toString();
    }

    /**
     * Solution:
     * - Time: O(nklogk)
     * - Space: O(nk)
     * where k is the maximum length of a string
     */
    public List<List<String>> groupAnagramsV1(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String key = getKeyV1(str);

            List<String> anagrams = groups.getOrDefault(key, new ArrayList<>());
            anagrams.add(str);
            groups.put(key, anagrams);
        }
        return groups.values().stream().collect(Collectors.toList());
    }

    private String getKeyV1(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
