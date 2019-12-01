package com.leetcode.easy.active;

import java.util.Arrays;

/**
 * Fibonacci Number
 * Link: https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int fibV3(int N) {
        if (N == 0 || N == 1) {
            return N;
        }

        int n1 = 0;
        int n2 = 1;
        int current;

        int i = 2;
        do {
            current = n1 + n2;

            n1 = n2;
            n2 = current;

            i++;
        } while (i <= N);

        return current;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int fibV2(int N) {
        int[] memo = new int[N + 1];
        Arrays.fill(memo, -1);

        return fib(N, memo);
    }

    private int fib(int N, int[] memo) {
        if (N == 0 || N == 1) {
            return N;
        }
        if (memo[N] < 0) {
            memo[N] = fib(N - 1, memo) + fib(N - 2, memo);
        }
        return memo[N];
    }

    /**
     * Solution:
     * - Time: O(2^n)
     * - Space: O(n)
     */
    public int fibV1(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        return fibV1(N - 1) + fibV1(N - 2);
    }
}
