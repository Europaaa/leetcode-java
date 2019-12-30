package com.leetcode.medium.archived;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Divide Array in Sets of K Consecutive Numbers
 * Link: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class DivideArrayInSetsOfKConsecutiveNumbers {

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Long> counters = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Integer[] numbers = counters.keySet().stream().sorted().toArray(Integer[]::new);
        for (int i = 0; i < numbers.length; ) {
            if (!counters.containsKey(numbers[i])) {
                i++;
                continue;
            }

            if (i + k > numbers.length) {
                return false;
            }

            for (int j = 0; j < k; j++) {
                if (counters.getOrDefault(numbers[i] + j, 0l) == 0l) {
                    return false;
                }
            }

            for (int j = 0; j < k; j++) {
                long counter = counters.get(numbers[i] + j) - 1;
                if (counter > 0) {
                    counters.put(numbers[i] + j, counter);
                } else {
                    counters.remove(numbers[i] + j);
                }
            }
        }
        return true;
    }
}
