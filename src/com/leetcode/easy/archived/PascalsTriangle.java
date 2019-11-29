package com.leetcode.easy.archived;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pascal's Triangle
 * Link: https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n^2)
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows >= 1) {
            triangle.add(Arrays.asList(1));
        }

        if (numRows >= 2) {
            triangle.add(Arrays.asList(1, 1));
        }

        int i = 3;
        while (i <= numRows) {
            List<Integer> numbers = triangle.get(i - 2);

            List<Integer> newNumbers = new ArrayList<>();
            newNumbers.add(1);
            for (int j = 0; j < numbers.size() - 1; j++) {
                newNumbers.add(numbers.get(j) + numbers.get(j + 1));
            }
            newNumbers.add(1);

            triangle.add(newNumbers);
            i++;
        }
        return triangle;
    }
}
