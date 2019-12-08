package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combinations
 * Link: https://leetcode.com/problems/combinations/
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        return backtrace(n, k, new ArrayList<>());
    }

    private List<List<Integer>> backtrace(int n, int k, List<Integer> values) {
        if (n == 0 || values.size() == k) {
            return Arrays.asList(values);
        }

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (!isValid(n, k, values, i)) {
                continue;
            }

            List<Integer> newValues = new ArrayList<>(values);
            newValues.add(i);

            results.addAll(backtrace(n, k, newValues));
        }
        return results;
    }

    private boolean isValid(int n, int k, List<Integer> values, int value) {
        if (value <= 0 && value > n) {
            return false;
        }
        if (values.size() > k) {
            return false;
        }
        return values.isEmpty() || values.get(values.size() - 1) < value;
    }
}

