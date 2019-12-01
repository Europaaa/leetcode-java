package com.leetcode.medium.active;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Contains Duplicate III
 * Link: https://leetcode.com/problems/contains-duplicate-iii/
 */
public class ContainsDuplicateIII {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(k)
     */
    public boolean containsNearbyAlmostDuplicateV3(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // Adjust the range so that we only consider positive numbers
            long num = getNumber(nums, i);
            long bucket = num / ((long) t + 1);

            if (buckets.containsKey(bucket) ||
                    (buckets.containsKey(bucket - 1) && num - buckets.get(bucket - 1) <= t) ||
                    (buckets.containsKey(bucket + 1) && buckets.get(bucket + 1) - num <= t)) {
                return true;
            }

            buckets.put(bucket, num);
            if (i - k >= 0) {
                buckets.remove(getNumber(nums, i - k) / ((long) t + 1));
            }
        }
        return false;
    }

    private long getNumber(int[] nums, int i) {
        return (long) nums[i] - Integer.MIN_VALUE;
    }

    /**
     * Solution:
     * - Time: O(nlogk)
     * - Space: O(k)
     */
    public boolean containsNearbyAlmostDuplicateV2(int[] nums, int k, int t) {
        if (nums.length == 0 || k <= 0) {
            return false;
        }

        TreeSet<Integer> window = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // The largest number less than or equal to nums[i]
            Integer floor = window.floor(num);
            // The smallest number greater than or equal to nums[i]
            Integer ceil = window.ceiling(num);

            if ((floor != null && (long) num - (long) floor <= t) || (ceil != null && (long) ceil - (long) num <= t)) {
                return true;
            }

            window.add(num);
            if (i - k >= 0) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(1)
     */
    public boolean containsNearbyAlmostDuplicateV1(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                long diff = Math.abs((long) nums[j] - (long) nums[i]);
                if (diff <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}
