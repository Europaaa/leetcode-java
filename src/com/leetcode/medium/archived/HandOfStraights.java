package com.leetcode.medium.archived;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Hand of Straights
 * Link: https://leetcode.com/problems/hand-of-straights/
 */
public class HandOfStraights {

    /**
     * Solution:
     * - Time: O(nW + nlogn)
     * - Space: O(n)
     */
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Long> counters = Arrays.stream(hand).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int[] cards = Arrays.stream(hand).distinct().sorted().toArray();
        for (int i = 0; i < cards.length;) {
            if (counters.getOrDefault(cards[i], 0l) == 0) {
                i++;
                continue;
            }

            for (int j = 0; j < W; j++) {
                Long count = counters.getOrDefault(cards[i] + j, 0l);
                if (count == 0) {
                    return false;
                }
                counters.put(cards[i] + j, count - 1);
            }
        }
        return true;
    }
}
