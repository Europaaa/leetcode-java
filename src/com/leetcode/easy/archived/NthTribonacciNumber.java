package com.leetcode.easy.archived;

import java.util.Arrays;

/**
 * N-th Tribonacci Number
 * Link: https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class NthTribonacciNumber {

    /**
     * Solution:
     * - Time: O(logn)
     * - Space: O(logn)
     */
    public int tribonacciV4(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }

        // Here are the Fibonnaci formulas:
        // f(n)     =   f(n - 1)    +   f(n - 2)    +   f(n - 3)
        // f(n - 1) =   f(n - 1)
        // f(n - 2) =                   f(n - 2)

        // We can rewrite the formulas in matrix form like this:
        // | f(n)     | = | 1 1 1 | * | f(n - 1) |
        // | f(n - 1) |   | 1 0 0 |   | f(n - 2) |
        // | f(n - 2) |   | 0 1 0 |   | f(n - 3) |
        // or
        // | f(n)     | = | 1 1 1 |^(n - 2) * | f(2) |
        // | f(n - 1) |   | 1 0 0 |           | f(1) |
        // | f(n - 2) |   | 0 1 0 |           | f(0) |

        // Since computing a matrix of size m to the power of k takes O(m^3 logk) time,
        // we can find the fibonacci number in O(logn) time

        int[][] matrix = new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 1, 0}};
        int[][] base = new int[][]{{1, 1, 0}};
        return multiply(power(matrix, N - 1), base)[0][0];
    }

    private int[][] power(int[][] matrix, int n) {
        if (n == 0 || n == 1) {
            return matrix;
        }

        int[][] result = power(matrix, n / 2);
        result = multiply(result, result);

        if (n % 2 == 1) {
            return multiply(result, matrix);
        }
        return result;
    }

    private int[][] multiply(int[][] F, int[][] M) {
        int[][] matrix = new int[F.length][M.length];
        for (int i = 0; i < F.length; i++) {
            for (int j = 0; j < M.length; j++) {
                matrix[i][j] = 0;
                for (int k = 0; k < M.length; k++) {
                    matrix[i][j] += F[i][k] * M[k][j];
                }
            }
        }
        return matrix;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int tribonacciV3(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }

        int n1 = 0;
        int n2 = 1;
        int n3 = 1;
        int current;

        int i = 3;
        do {
            current = n1 + n2 + n3;

            n1 = n2;
            n2 = n3;
            n3 = current;

            i++;
        } while (i <= N);

        return current;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int tribonacciV2(int N) {
        int[] memo = new int[N + 1];
        Arrays.fill(memo, -1);

        return tribonacci(N, memo);
    }

    private int tribonacci(int N, int[] memo) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        if (memo[N] < 0) {
            memo[N] = tribonacci(N - 1, memo) + tribonacci(N - 2, memo) + tribonacci(N - 3, memo);
        }
        return memo[N];
    }

    /**
     * Solution:
     * - Time: O(3^n)
     * - Space: O(n)
     */
    public int tribonacciV1(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        return tribonacciV1(N - 1) + tribonacciV1(N - 2) + tribonacciV1(N - 3);
    }
}
