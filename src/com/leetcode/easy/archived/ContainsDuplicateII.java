package com.leetcode.easy.archived;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains Duplicate II
 * Link: https://leetcode.com/problems/contains-duplicate-ii/
 */
public class ContainsDuplicateII {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public boolean containsNearbyDuplicateV2(int[] nums, int k) {
        Map<Integer, Integer> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indices.containsKey(nums[i])) {
                if (i - indices.get(nums[i]) <= k) {
                    return true;
                }
            }
            indices.put(nums[i], i);
        }
        return false;
    }

    /**
     * Solution:
     * - Time: O(nk)
     * - Space: O(1)
     */
    public boolean containsNearbyDuplicateV1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= k && i + j < nums.length; j++) {
                if (nums[i] == nums[i + j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
