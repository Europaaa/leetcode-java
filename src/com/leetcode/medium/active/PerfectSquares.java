package com.leetcode.medium.active;

/**
 * Perfect Squares
 * Link: https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n)
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
