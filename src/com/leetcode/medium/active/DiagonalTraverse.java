package com.leetcode.medium.active;

/**
 * Diagonal Traverse
 * Link: https://leetcode.com/problems/diagonal-traverse/
 */
public class DiagonalTraverse {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(1)
     */
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int r = 0;
        int c = 0;

        int values[] = new int[m * n];
        for (int i = 0; i < values.length; i++) {
            values[i] = matrix[r][c];

            // Moving up
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            }

            // Moving down
            else {
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return values;
    }
}
