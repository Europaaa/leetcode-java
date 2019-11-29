package com.leetcode.easy.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pascal's Triangle II
 * Link: https://leetcode.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> getRowV3(int row) {
        Integer[] numbers = new Integer[row + 1];

        numbers[0] = 1;
        for (int i = 1; i < row + 1; i++) {
            numbers[i] = (int) ((long) numbers[i - 1] * (row - (i - 1)) / i);
        }
        return Arrays.asList(numbers);
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public List<Integer> getRowV2(int row) {
        Integer[] numbers = new Integer[row + 1];
        Arrays.fill(numbers, 1);
        for (int i = 0; i < row; i++) {
            for (int j = i; j > 0; j--) {
                numbers[j] += numbers[j - 1];
            }
        }
        return Arrays.asList(numbers);
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n^2)
     */
    public List<Integer> getRowV1(int row) {
        if (row == 0) {
            return Arrays.asList(1);
        }
        if (row == 1) {
            return Arrays.asList(1, 1);
        }

        List<Integer> numbers = getRowV1(row - 1);

        List<Integer> newNumbers = new ArrayList<>();
        newNumbers.add(1);
        for (int j = 0; j < numbers.size() - 1; j++) {
            newNumbers.add(numbers.get(j) + numbers.get(j + 1));
        }
        newNumbers.add(1);
        return newNumbers;
    }
}
