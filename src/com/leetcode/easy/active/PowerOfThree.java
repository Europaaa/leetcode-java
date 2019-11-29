package com.leetcode.easy.active;

/**
 * Power Of Three
 * Link: https://leetcode.com/problems/power-of-three/
 */
public class PowerOfThree {

    /**
     * Solution:
     * - Time: Unknown
     * - Space: log_3 (n)
     */
    public boolean isPowerOfThreeV3(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    /**
     * Solution:
     * - Time: log_3 (n)
     * - Space: log_3 (n)
     */
    public boolean isPowerOfThreeV2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }

    /**
     * Solution:
     * - Time: log_3 (n)
     * - Space: O(1)
     */
    public boolean isPowerOfThreeV1(int n) {
        int p = 0;
        double v = Math.pow(3, p);

        while (v < n) {
            v = Math.pow(3, ++p);
        }

        return v == n;
    }
}
