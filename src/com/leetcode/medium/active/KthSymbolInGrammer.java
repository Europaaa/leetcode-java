package com.leetcode.medium.active;

/**
 * K-th Symbol in Grammar
 * Link: https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
public class KthSymbolInGrammer {

    /**
     * Solution:
     * - Time: O(logK)
     * - Space: O(logK)
     */
    public int kthGrammar(int N, int K) {
        return getKthDigit(K - 1);
    }

    private int getKthDigit(int K) {
        if (K == 0) {
            return 0;
        }
        if (K % 2 == 0) {
            return getKthDigit(K / 2);
        }
        return 1 - getKthDigit(K / 2);
    }
}
