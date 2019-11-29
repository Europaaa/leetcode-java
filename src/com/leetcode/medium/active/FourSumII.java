package com.leetcode.medium.active;

import java.util.HashMap;
import java.util.Map;

/**
 * 4Sum II
 * Link: https://leetcode.com/problems/4sum-ii/
 */
public class FourSumII {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n^2)
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> sums1 = getPossibleSumCounts(A, B);
        Map<Integer, Integer> sums2 = getPossibleSumCounts(C, D);

        int counter = 0;
        for (Integer sum1 : sums1.keySet()) {
            counter += sums1.getOrDefault(sum1, 0) * sums2.getOrDefault(-sum1, 0);
        }
        return counter;
    }

    private Map<Integer, Integer> getPossibleSumCounts(int[] A, int[] B) {
        Map<Integer, Integer> sums = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int s = a + b;
                sums.put(s, sums.getOrDefault(s, 0) + 1);
            }
        }
        return sums;
    }
}
