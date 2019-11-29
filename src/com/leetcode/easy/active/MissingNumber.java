package com.leetcode.easy.active;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Missing Number
 * Link: https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    /**
     * Solution: Bit Manipulation
     * - Time: O(n)
     * - Space: O(1)
     */
    public int missingNumberV4(int[] nums) {
        int n = nums.length;

        int v = n;
        for (int i = 0; i < n; i++) {
            v ^= i ^ nums[i];
        }
        return v;
    }

    /**
     * Solution: Sorting
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public int missingNumberV3(int[] nums) {
        int n = nums.length;

        int[] numbers = Arrays.copyOf(nums, n);
        Arrays.sort(numbers);

        for (int i = 0; i < n; i++) {
            if (numbers[i] != i) {
                return i;
            }
        }
        return n;
    }

    /**
     * Solution: Hash Set
     * - Time: O(n)
     * - Space: O(n)
     */
    public int missingNumberV2(int[] nums) {
        int n = nums.length;

        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);

        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        throw new RuntimeException();
    }

    /**
     * Solution: Gauss' Formula
     * - Time: O(n)
     * - Space: O(1)
     */
    public int missingNumberV1(int[] nums) {
        int n = nums.length;

        int sum = n * (n + 1) / 2;
        return sum - Arrays.stream(nums).sum();
    }
}
