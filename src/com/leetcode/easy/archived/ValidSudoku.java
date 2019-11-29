package com.leetcode.easy.archived;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Valid Sudoku
 * Link: https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     * where n is a constant, 9, in this case.
     */
    public boolean isValidSudoku(char[][] board) {
        if (!checkDigits(board)) {
            return false;
        }

        if (IntStream.range(0, board.length).mapToObj(i -> isValidRow(board, i)).anyMatch(v -> !v)) {
            return false;
        }

        if (IntStream.range(0, board[0].length).mapToObj(i -> isValidColumn(board, i)).anyMatch(v -> !v)) {
            return false;
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                if (!isValidSubBox(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkDigits(char[][] board) {
        for (int i = 0; i < board.length; i += 3)
            for (int j = 0; j < board[i].length; j += 3) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (c < '1' || c > '9') {
                    return false;
                }
            }
        return true;
    }

    private boolean isValidRow(char[][] board, int i) {
        Set<Character> set = new HashSet<>();

        for (int j = 0; j < board[i].length; j++) {
            char c = board[i][j];
            if (c == '.') {
                continue;
            }
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    private boolean isValidColumn(char[][] board, int i) {
        Set<Character> set = new HashSet<>();

        for (int j = 0; j < board.length; j++) {
            char c = board[j][i];
            if (c == '.') {
                continue;
            }
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    private boolean isValidSubBox(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();

        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                char v = board[r][c];
                if (v == '.') {
                    continue;
                }
                if (set.contains(v)) {
                    return false;
                }
                set.add(v);
            }
        }
        return true;
    }
}
