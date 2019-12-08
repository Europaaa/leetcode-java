package com.leetcode.easy.archived;

/**
 *
 * Link: https://leetcode.com/problems/defanging-an-ip-address/
 */
public class DefangingAnIPAddress {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                builder.append("[.]");
            } else {
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }
}
