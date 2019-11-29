package com.leetcode.easy.archived;

/**
 * Add Binary
 * Link: https://leetcode.com/problems/add-binary/
 */
public class AddBinary {

    /**
     * Solution
     * - Time: O(n)
     * - Space: O(1)
     */
    public String addBinary(String a, String b) {
        char[] digits1 = a.toCharArray();
        char[] digits2 = b.toCharArray();

        int i1 = digits1.length - 1;
        int i2 = digits2.length - 1;
        int i = 0;

        StringBuilder builder = new StringBuilder();

        boolean advance = false;
        for (; i1 >= 0 || i2 >= 0; i1--, i2--, i++) {
            int v1 = i1 >= 0 && digits1[i1] == '1' ? 1 : 0;
            int v2 = i2 >= 0 && digits2[i2] == '1' ? 1 : 0;
            int v = advance ? 1 : 0;

            advance = v1 + v2 + v > 1;

            if ((v1 + v2 + v) % 2 == 0) {
                builder.append('0');
            } else {
                builder.append('1');
            }
        }

        if (advance) {
            builder.append('1');
        }
        return builder.reverse().toString();
    }
}
