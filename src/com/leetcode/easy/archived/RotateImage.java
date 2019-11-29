package com.leetcode.easy.archived;

/**
 * Rotate Image
 * Link: https://leetcode.com/problems/rotate-image/
 */
public class RotateImage {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(1)
     */
    public void rotate(int[][] matrix) {
        rotate(matrix, 0);
    }

    private void rotate(int[][] matrix, int start) {
        int n = matrix.length;

        if (start >= n / 2) {
            return;
        }

        for (int i = start; i < n - start - 1; i++) {
            int v1 = matrix[start][i];
            int v2 = matrix[i][n - start - 1];
            int v3 = matrix[n - start - 1][n - i - 1];
            int v4 = matrix[n - i - 1][start];

            matrix[start][i] = v4;
            matrix[i][n - start - 1] = v1;
            matrix[n - start - 1][n - i - 1] = v2;
            matrix[n - i - 1][start] = v3;
        }

        rotate(matrix, start + 1);
    }
}
