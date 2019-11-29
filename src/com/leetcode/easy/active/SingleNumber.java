package com.leetcode.easy.active;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Single Number
 * Link: https://leetcode.com/problems/single-number/
 */
public class SingleNumber {

    /**
     * Solution 2: Bit Manipulation
     * - Time: O(n)
     * - Space: O(1)
     */
    public int singleNumberV2(int[] nums) {
        int v = 0;
        for (int i = 0; i < nums.length; i++) {
            v ^= nums[i];
        }
        return v;
    }

    /**
     * Solution 1: Hash Table
     * - Time: O(n)
     * - Space: O(n)
     */
    public int singleNumberV1(int[] nums) {
        Map<Integer, Long> counters = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return counters.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().get();
    }
}
