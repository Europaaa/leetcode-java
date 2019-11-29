package com.leetcode.medium.active;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Daily Temperatures
 * Link: https://leetcode.com/problems/daily-temperatures/
 */
public class DailyTemperatures {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(k)
     * where k is the number of available values for T[i]
     */
    public int[] dailyTemperaturesV2(int[] T) {
        int[] results = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            results[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return results;
    }

    private static final int MAX_TEMPERATURE = 100;

    /**
     * Solution:
     * - Time: O(nk)
     * - Space: O(k)
     * where k is the number of available values for T[i]
     */
    public int[] dailyTemperaturesV1(int[] T) {
        Map<Integer, Integer> indices = new HashMap<>();

        int[] results = new int[T.length];
        Arrays.fill(results, Integer.MAX_VALUE);

        for (int i = T.length - 1; i >= 0; i--) {
            for (int t = T[i] + 1; t <= MAX_TEMPERATURE; t++) {
                if (indices.containsKey(t)) {
                    results[i] = Math.min(indices.get(t) - i, results[i]);
                }
            }
            if (results[i] == Integer.MAX_VALUE) {
                results[i] = 0;
            }
            indices.put(T[i], i);
        }
        return results;
    }
}
