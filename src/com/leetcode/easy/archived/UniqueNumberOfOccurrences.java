package com.leetcode.easy.archived;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Unique Number of Occurrences
 * Link: https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class UniqueNumberOfOccurrences {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Long> counters = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Set<Long> occurrence = new HashSet<>(counters.values());
        return counters.size() == occurrence.size();
    }
}
