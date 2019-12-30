package com.leetcode.easy.active;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KdiffPairsInAnArray {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int findPairsV2(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        Set<Integer> numbers = new HashSet<>();
        // Stores the smaller one from the pair
        Set<Integer> pairs = new HashSet<>();
        for (int n : nums) {
            if (numbers.contains(n + k)) {
                pairs.add(n);
            }
            if (numbers.contains(n - k)) {
                pairs.add(n - k);
            }
            numbers.add(n);
        }
        return pairs.size();
    }

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public int findPairsV1(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 0;

        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }

            if (nums[j] - nums[i] == k) {
                count++;
                i++;
                j++;
            } else if (nums[j] - nums[i] < k) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }
}
