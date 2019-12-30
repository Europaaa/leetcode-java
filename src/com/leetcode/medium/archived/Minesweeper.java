package com.leetcode.medium.archived;

/**
 * Minesweeper
 * Link: https://leetcode.com/problems/minesweeper/
 */
public class Minesweeper {

    private static final char CELL_SPACE = 'E';
    private static final char CELL_SPACE_REVEALED = 'B';
    private static final char CELL_MINE = 'M';
    private static final char CELL_MINE_REVEALED = 'X';

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n^2)
     * where n is the max of the row number and column number
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        int y = click[0];
        int x = click[1];

        if (board[y][x] == CELL_MINE) {
            board[y][x] = CELL_MINE_REVEALED;
            return board;
        }
        return updateBoard(board, x, y);
    }

    private char[][] updateBoard(char[][] board, int x, int y) {
        if (!valid(board, x, y)) {
            return board;
        }

        if (board[y][x] == CELL_MINE || board[y][x] == CELL_MINE_REVEALED || board[y][x] == CELL_SPACE_REVEALED || Character.isDigit(board[y][x])) {
            return board;
        }

        int mineCount = getMineCount(board, x, y);
        if (mineCount > 0) {
            board[y][x] = (char) ('0' + mineCount);
            return board;
        }

        board[y][x] = CELL_SPACE_REVEALED;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                board = updateBoard(board, x + i, y + j);
            }
        }
        return board;
    }

    private boolean valid(char[][] board, int x, int y) {
        return y >= 0 && y < board.length && x >= 0 && x < board[y].length;
    }

    private int getMineCount(char[][] board, int x, int y) {
        return getMine(board, x - 1, y - 1) + getMine(board, x, y - 1) + getMine(board, x + 1, y - 1)
                + getMine(board, x - 1, y) + getMine(board, x + 1, y)
                + getMine(board, x - 1, y + 1) + getMine(board, x, y + 1) + getMine(board, x + 1, y + 1);
    }

    private int getMine(char[][] board, int x, int y) {
        boolean mine = valid(board, x, y) && board[y][x] == CELL_MINE;
        return mine ? 1 : 0;
    }
}
