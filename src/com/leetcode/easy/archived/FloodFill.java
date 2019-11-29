package com.leetcode.easy.archived;

/**
 * Flood Fill
 * Link: https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n^2)
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0) {
            return image;
        }

        int origColor = image[sr][sc];
        if (origColor == newColor) {
            return image;
        }

        floodFill(image, sr, sc, origColor, newColor);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int origColor, int newColor) {
        if (image[sr][sc] != origColor) {
            return;
        }

        image[sr][sc] = newColor;
        if (sr - 1 >= 0) {
            floodFill(image, sr - 1, sc, origColor, newColor);
        }
        if (sr + 1 < image.length) {
            floodFill(image, sr + 1, sc, origColor, newColor);
        }
        if (sc - 1 >= 0) {
            floodFill(image, sr, sc - 1, origColor, newColor);
        }
        if (sc + 1 < image[0].length) {
            floodFill(image, sr, sc + 1, origColor, newColor);
        }
    }
}
