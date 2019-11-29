package com.leetcode.easy.active;

import java.util.Arrays;

/**
 * Reverse Integer
 * Link: https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

    /**
     * Solution:
     * - Time: O(log_10 x)
     * - Space: O(1)
     */
    public int reverseV2(int x) {
        int v = x;
        int n = 0;

        while (v != 0) {
            int digit = v % 10;
            v = v / 10;

            if (n > Integer.MAX_VALUE/10 || n == Integer.MAX_VALUE/10 && digit > 7) {
                return 0;
            }
            if (n < Integer.MIN_VALUE/10 || n == Integer.MIN_VALUE/10 && digit < -8) {
                return 0;
            }

            n = n * 10 + digit;
        }
        return n;
    }

    /**
     * Solution:
     * - Time: O(log_10 x)
     * - Space: O(log_10 x)
     */
    public int reverseV1(int x) {
        int m = 1;
        char[] digits = String.valueOf(x).toCharArray();

        if (x < 0) {
           m = -1;
           digits = Arrays.copyOfRange(digits, 1, digits.length);
        }

        reverseString(digits);

        Long result = Long.valueOf(new String(digits));
        if (result >= Integer.MAX_VALUE) {
            return 0;
        }
        return m * Integer.valueOf(new String(digits));
    }

    private void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
}
