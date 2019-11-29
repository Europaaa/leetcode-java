package com.leetcode.easy.active;

import java.util.Arrays;

/**
 * Climbing Stairs
 * Link: https://leetcode.com/submissions/detail/274386351/
 */
public class ClimbingStairs {

    /**
     * Solution: Fibonacci Number
     * - Time: O(n)
     * - Space: O(1)
     */
    public int climbStairsV3(int n) {
        if (n == 1) {
            return 1;
        }

        int v1 = 1;
        int v2 = 2;

        for (int i = 3; i <= n; i++) {
            int v = v1 + v2;
            v1 = v2;
            v2 = v;
        }
        return v2;
    }

    /**
     * Solution: Dynamic Programming
     * - Time: O(n)
     * - Space: O(n)
     */
    public int climbStairsV2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Solution: Recursive with Memorization
     * - Time: O(n)
     * - Space: O(n)
     */
    public int climbStairsV1(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return climbStairs(n, memo);
    }

    private int climbStairs(int n, int[] memo) {
        if (n == 1) {
            memo[1] = 1;
        }
        if (n == 2) {
            memo[2] = 2;
        }

        if (memo[n] >= 0) {
            return memo[n];
        }

        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        return memo[n];
    }
}
