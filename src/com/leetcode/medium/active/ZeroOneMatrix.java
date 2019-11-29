package com.leetcode.medium.active;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 01 Matrix
 * Link: https://leetcode.com/problems/01-matrix/
 */
public class ZeroOneMatrix {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n^2)
     */
    public int[][] updateMatrixV2(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] distance = new int[n][m];
        Arrays.stream(distance).forEach(d -> Arrays.fill(d, Integer.MAX_VALUE - 1));

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] coords = queue.poll();

            int i = coords[0];
            int j = coords[1];

            if (i - 1 >= 0) {
                if (distance[i - 1][j] > distance[i][j] + 1) {
                    distance[i - 1][j] = distance[i][j] + 1;
                    queue.offer(new int[]{i - 1, j});
                }
            }
            if (i + 1 < n) {
                if (distance[i + 1][j] > distance[i][j] + 1) {
                    distance[i + 1][j] = distance[i][j] + 1;
                    queue.offer(new int[]{i + 1, j});
                }
            }
            if (j - 1 >= 0) {
                if (distance[i][j - 1] > distance[i][j] + 1) {
                    distance[i][j - 1] = distance[i][j] + 1;
                    queue.offer(new int[]{i, j - 1});
                }
            }
            if (j + 1 < m) {
                if (distance[i][j + 1] > distance[i][j] + 1) {
                    distance[i][j + 1] = distance[i][j] + 1;
                    queue.offer(new int[]{i, j + 1});
                }
            }
        }
        return distance;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(1)
     */
    public int[][] updateMatrixV1(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] distance = new int[n][m];
        Arrays.stream(distance).forEach(d -> Arrays.fill(d, Integer.MAX_VALUE - 1));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    distance[i][j] = 0;
                    continue;
                }

                if (i > 0) {
                    distance[i][j] = Math.min(distance[i][j], distance[i - 1][j] + 1);
                }
                if (j > 0) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][j - 1] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i + 1 < n) {
                    distance[i][j] = Math.min(distance[i][j], distance[i + 1][j] + 1);
                }
                if (j + 1 < m) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][j + 1] + 1);
                }
            }
        }
        return distance;
    }
}
