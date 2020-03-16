package com.leetcode.easy.active;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * How Many Numbers Are Smaller Than the Current Number
 * Link: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int[] smallerNumbersThanCurrentV2(int[] nums) {
        int[] counters = new int[101];

        Arrays.stream(nums).forEach(n -> counters[n]++);
        for (int i = 1; i < counters.length; i++) {
            counters[i] += counters[i - 1];
        }

        return Arrays.stream(nums).map(n -> {
            if (n == 0) {
                return 0;
            }
            return counters[n - 1];
        }).toArray();
    }

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        List<Integer> numsSorted = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
        Map<Integer, Integer> indices = IntStream.range(0, numsSorted.size()).boxed()
                .collect(Collectors.toMap(numsSorted::get, Function.identity(), Math::min));
        return Arrays.stream(nums).map(indices::get).toArray();
    }
}
