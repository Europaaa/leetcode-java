package com.leetcode.easy.active;

/**
 * Best Time to Buy and Sell Stock II
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit += Math.max(prices[i] - prices[i - 1], 0);
        }
        return profit;
    }
}
