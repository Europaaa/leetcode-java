package com.leetcode.medium.active;

/**
 * Search a 2D Matrix II
 * Link: https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class SearchA2DMatrixII {

    /**
     * Solution:
     * - Time: O(m+n)
     * - Space: O(1)
     */
    public boolean searchMatrixV2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int column = matrix[0].length - 1;

        while (column >= 0 && row < matrix.length) {
            if (target == matrix[row][column]) {
                return true;
            }
            if (target < matrix[row][column]) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * Solution:
     * - Time: O(mn)
     * - Space: O(1)
     */
    public boolean searchMatrixV1(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
