package com.leetcode.medium.archived;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * Link: https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int minY = 0;
        int maxY = matrix.length;

        if (maxY == 0) {
            return new ArrayList<>();
        }

        int minX = 0;
        int maxX = matrix[0].length;

        List<Integer> numbers = new ArrayList<>();

        int x = 0;
        int y = 0;

        int dirX = 1;
        int dirY = 0;
        while (minX <= x && x < maxX && minY <= y && y < maxY) {
            numbers.add(matrix[y][x]);

            if (!(minX <= x + dirX && x + dirX < maxX && minY <= y + dirY && y + dirY < maxY)) {
                if (dirX == 1 && dirY == 0) {
                    dirX = 0;
                    dirY = 1;
                    minY += 1;
                } else if (dirX == 0 && dirY == 1) {
                    dirX = -1;
                    dirY = 0;
                    maxX -= 1;
                } else if (dirX == -1 && dirY == 0) {
                    dirX = 0;
                    dirY = -1;
                    maxY -= 1;
                } else {
                    dirX = 1;
                    dirY = 0;
                    minX += 1;
                }
            }

            x = x + dirX;
            y = y + dirY;
        }
        return numbers;
    }
}
