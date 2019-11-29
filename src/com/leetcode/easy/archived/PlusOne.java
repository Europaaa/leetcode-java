package com.leetcode.easy.archived;

import java.util.Arrays;

/**
 * Plus One
 * Link: https://leetcode.com/problems/plus-one/
 */
public class PlusOne {

    /**
     * Solution
     * - Time: O(n)
     * - Space: O(n)
     */
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result = Arrays.copyOf(digits, n);

        int i = n - 1;
        while (i >= 0) {
            if (result[i] == 9) {
                result[i--] = 0;
            } else {
                result[i] = result[i] + 1;
                return result;
            }
        }

        int[] advanced = new int[n + 1];
        advanced[0] = 1;
        for (int j = 0; j < n; j++) {
            advanced[j + 1] = result[j];
        }
        return advanced;
    }
}
