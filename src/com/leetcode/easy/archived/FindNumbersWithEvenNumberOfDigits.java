package com.leetcode.easy.archived;

import java.util.Arrays;

/**
 * Find Numbers with Even Number of Digits
 * Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class FindNumbersWithEvenNumberOfDigits {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums).filter(this::hasEventNumberOfDigits).count();
    }

    private boolean hasEventNumberOfDigits(int num) {
        return String.valueOf(num).length() % 2 == 0;
    }
}
