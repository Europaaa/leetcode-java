package com.leetcode.hard.archived;

/**
 * Sudoku Solver
 * Link: https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {

    private static final char EMPTY_CELL = '.';

    public void solveSudoku(char[][] board) {
        backtrace(board);
    }

    private boolean backtrace(char[][] board) {
        int n = board.length;

        int row = -1;
        int column = -1;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == EMPTY_CELL) {
                    row = r;
                    column = c;
                    break;
                }
            }
        }

        if (row == -1 && column == -1) {
            return true;
        }

        for (char num = '1'; num <= '9'; num++) {
            if (!isValid(board, row, column, num)) {
                continue;
            }

            place(board, row, column, num);
            if (backtrace(board)) {
                return true;
            }
            remove(board, row, column);
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int column, char num) {
        int n = board.length;

        if (board[row][column] != EMPTY_CELL) {
            return false;
        }

        // Check the row
        for (int i = 0; i < n; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check the column
        for (int i = 0; i < n; i++) {
            if (board[i][column] == num) {
                return false;
            }
        }

        // Check the box
        for (int i = 0; i < n; i++) {
            int cell = board[3 * (row / 3) + i / 3][3 * (column / 3) + i % 3];
            if (cell == num) {
                return false;
            }
        }
        return true;
    }

    private void place(char[][] board, int row, int column, char num) {
        board[row][column] = num;
    }

    private void remove(char[][] board, int row, int column) {
        board[row][column] = EMPTY_CELL;
    }
}
