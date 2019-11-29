package com.leetcode.medium.active;

/**
 * Set Matrix Zeros
 * Link: https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeros {

    /**
     * Solution:
     * - Time: O(mn)
     * - Space: O(1)
     */
    public void setZeroesV2(int[][] matrix) {
        boolean columnZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnZero = true;
            }

            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (columnZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Solution:
     * - Time: O(mn)
     * - Space: O(m + n)
     */
    public void setZeroesV1(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            rows[i] = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            columns[i] = false;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 0) {
                    columns[i] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
