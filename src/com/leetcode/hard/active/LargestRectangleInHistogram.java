package com.leetcode.hard.active;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int largestRectangleAreaV2(int[] heights) {
        int n = heights.length;

        int largestArea = 0;

        // The stack keeps indices of  heights that's smaller than the current one
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int minHeight = heights[stack.pop()];
                int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                largestArea = Math.max(minHeight * width, largestArea);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int minHeight = heights[stack.pop()];
            int width = n - (stack.isEmpty() ? 0 : stack.peek() + 1);
            largestArea = Math.max(minHeight * width, largestArea);
        }
        return largestArea;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(1)
     */
    public int largestRectangleAreaV1(int[] heights) {
        int n = heights.length;

        int largestArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = heights[i];
            largestArea = Math.max(minHeight, largestArea);
            for (int j = i + 1; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                largestArea = Math.max(minHeight * (j - i + 1), largestArea);
            }
        }
        return largestArea;
    }
}
