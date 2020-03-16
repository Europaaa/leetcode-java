package com.leetcode.easy.active;

import java.util.Arrays;
import java.util.Stack;

/**
 * Shortest Unsorted Continuous Subarray
 * Link: https://leetcode.com/problems/shortest-unsorted-continuous-subarray
 */
public class ShortestUnsortedContinuousSubarray {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int findUnsortedSubarrayV3(int[] nums) {
        boolean unsorted = false;

        int minV = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                unsorted = true;
            }
            if (unsorted) {
                minV = Math.min(minV, nums[i]);
            }
        }

        unsorted = false;
        int maxV = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                unsorted = true;
            }
            if (unsorted) {
                maxV = Math.max(maxV, nums[i]);
            }
        }

        int min = 0;
        for (; min < nums.length && nums[min] <= minV; min++) {
        }

        int max = nums.length - 1;
        for (; max >= 0 && nums[max] >= maxV; max--) {
        }

        return max - min > 0 ? max - min + 1 : 0;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int findUnsortedSubarrayV2(int[] nums) {
        Stack<Integer> stackAsc = new Stack<>();

        int min = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!stackAsc.isEmpty() && nums[stackAsc.peek()] > nums[i]) {
                min = Math.min(min, stackAsc.pop());
            }
            stackAsc.push(i);
        }

        Stack<Integer> stackDesc = new Stack<>();
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stackDesc.isEmpty() && nums[stackDesc.peek()] < nums[i]) {
                max = Math.max(max, stackDesc.pop());

            }
            stackDesc.push(i);
        }
        return max - min > 0 ? max - min + 1 : 0;
    }

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public int findUnsortedSubarrayV1(int[] nums) {
        int[] numsSorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsSorted);

        int min = 0;
        for (; min < nums.length && nums[min] == numsSorted[min]; min++) {
        }

        int max = nums.length - 1;
        for (; max >= min && nums[max] == numsSorted[max]; max++) {
        }

        return max - min + 1;
    }
}
