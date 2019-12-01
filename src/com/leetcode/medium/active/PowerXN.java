package com.leetcode.medium.active;

/**
 * Pow(x, n)
 * Link: https://leetcode.com/problems/powx-n/
 */
public class PowerXN {

    /**
     * Solution:
     * - Time: O(logn)
     * - Space: O(1)
     */
    public double myPowV3(double x, int n) {
        if (x == 0 || n == 0) {
            return 1;
        }

        double base = n > 0 ? x : 1 / x;
        // Math.abs(Integer.MIN_VALUE) is still negative due to integer overflow
        long exp = Math.abs((long) n);

        double result = 1;
        while (exp != 0) {
            if (exp % 2 == 1) {
                result *= base;
            }
            base *= base;
            exp = exp / 2;
        }
        return result;
    }

    /**
     * Solution:
     * - Time: O(logn)
     * - Space: O(1)
     */
    public double myPowV2(double x, int n) {
        if (x == 0 || n == 0) {
            return 1;
        }
        double base = n > 0 ? x : 1 / x;
        return power(base, Math.abs(n), 1);
    }

    private double power(double base, int exp, double result) {
        if (exp == 0) {
            return result;
        }
        double newBase = base * base;
        int newExp = exp / 2;
        return exp % 2 == 0 ? power(newBase, newExp, result) : power(newBase, newExp, result * base);
    }

    /**
     * Solution:
     * - Time: O(logn)
     * - Space: O(logn)
     */
    public double myPowV1(double x, int n) {
        if (x == 0 || n == 0) {
            return 1;
        }
        double base = n > 0 ? x : 1 / x;
        return power(base, Math.abs(n));
    }

    private double power(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        double newBase = base * base;
        int newExp = exp / 2;
        return exp % 2 == 0 ? power(newBase, newExp) : base * power(newBase, newExp);
    }
}
