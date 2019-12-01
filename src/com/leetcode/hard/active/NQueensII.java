package com.leetcode.hard.active;

/**
 * N-Queens II
 * Link: https://leetcode.com/problems/n-queens-ii/
 */
public class NQueensII {

    /**
     * Solution:
     * - Time: O(n!)
     * - Space: O(n^2)
     */
    public int totalNQueens(int n) {
        boolean[] column = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        return backtrace(column, diag1, diag2, 0);
    }

    private int backtrace(boolean[] columns, boolean[] diag1, boolean[] diag2, int row) {
        if (row >= columns.length) {
            return 1;
        }

        int count = 0;
        for (int c = 0; c < columns.length; c++) {
            if (!isValid(columns, diag1, diag2, row, c)) {
                continue;
            }

            place(columns, diag1, diag2, row, c);
            count += backtrace(columns, diag1, diag2, row + 1);
            remove(columns, diag1, diag2, row, c);
        }
        return count;
    }

    private boolean isValid(boolean[] columns, boolean[] diag1, boolean[] diag2, int row, int column) {
        int n = columns.length;
        if (columns[column] || diag1[column - row + n] || diag2[row + column]) {
            return false;
        }
        return true;
    }

    private void place(boolean[] columns, boolean[] diag1, boolean[] diag2, int row, int column) {
        int n = columns.length;
        columns[column] = true;
        diag1[column - row + n] = true;
        diag2[row + column] = true;
    }

    private void remove(boolean[] columns, boolean[] diag1, boolean[] diag2, int row, int column) {
        int n = columns.length;
        columns[column] = false;
        diag1[column - row + n] = false;
        diag2[row + column] = false;
    }
}
