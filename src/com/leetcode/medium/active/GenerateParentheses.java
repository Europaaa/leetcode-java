package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Generate Parentheses
 * Link: https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    /**
     * Solution:
     * - Time: O(4^n / sqrt(n))
     * - Space: O(4^n / sqrt(n))
     */
    public List<String> generateParenthesisV3(int n) {
        return generateParenthesis("", n, n);
    }

    public List<String> generateParenthesis(String value, int open, int close) {
        if (open == 0 && close == 0) {
            return Arrays.asList(value);
        }
        if (open > close) {
            return Arrays.asList();
        }

        List<String> results = new ArrayList<>();
        if (open > 0) {
            results.addAll(generateParenthesis(value + "(", open - 1, close));
        }
        if (open < close) {
            results.addAll(generateParenthesis(value + ")", open, close - 1));
        }
        return results;
    }

    public List<String> generateParenthesisV2(int n) {
        List<List<String>> memo = new ArrayList<>();
        memo.add(Collections.singletonList(""));

        for (int i = 1; i <= n; i++) {
            List<String> results = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                for (final String first : memo.get(j)) {
                    for (final String second : memo.get(i - 1 - j)) {
                        results.add("(" + first + ")" + second);
                    }
                }
            }
            memo.add(results);
        }
        return memo.get(memo.size() - 1);
    }

    /**
     * Solution:
     * - Time: O(4^n / sqrt(n))
     * - Space: O(4^n / sqrt(n))
     */
    public List<String> generateParenthesisV1(int n) {
        List<String> results = new ArrayList<>();
        if (n == 0) {
            results.add("");
            return results;
        }

        for (int i = 0; i < n; i++) {
            List<String> results1 = generateParenthesisV1(n - i - 1);
            List<String> results2 = generateParenthesisV1(i);

            for (String part1 : results1) {
                for (String part2 : results2) {
                    results.add("(" + part1 + ")" + part2);
                }
            }
        }

        return results;
    }
}
