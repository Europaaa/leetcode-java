package com.leetcode.easy.archived;

/**
 * Flipping an Image
 * Link: https://leetcode.com/problems/flipping-an-image
 */
public class FlippingAnImage {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(1)
     */
    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0) {
            return A;
        }

        int n = A.length;
        int m = A[0].length;

        int[][] copy = new int[n][m];
        for (int r = 0; r < A.length; r++) {
            for (int c = 0; c < m; c++) {
                copy[r][m - c - 1] = 1 - A[r][c];
            }
        }
        return copy;
    }
}
