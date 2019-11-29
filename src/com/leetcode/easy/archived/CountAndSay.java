package com.leetcode.easy.archived;

/**
 * Count and Say
 * Link: https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        char[] chars = countAndSay(n - 1).toCharArray();

        String result = "";

        char d = chars[0];
        int c = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == d) {
                c++;
            } else {
                result += String.valueOf(c) + d;

                d = chars[i];
                c = 1;
            }
        }
        return result + String.valueOf(c) + d;
    }
}
