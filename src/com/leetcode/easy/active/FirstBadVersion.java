package com.leetcode.easy.active;

/**
 * First Bad Version
 * Link: https://leetcode.com/problems/first-bad-version/
 */
public abstract class FirstBadVersion {

    public abstract boolean isBadVersion(int version);

    /**
     * Solution:
     * - Time: O(log n)
     * - Space: O(1)
     */
    public int firstBadVersion(int n) {
        int i = 1;
        int j = n;

        while (i < j) {
            int m = i + (j - i) / 2;
            if (isBadVersion(m)) {
                j = m;
            } else {
                i = m + 1;
            }
        }
        return i;
    }
}
