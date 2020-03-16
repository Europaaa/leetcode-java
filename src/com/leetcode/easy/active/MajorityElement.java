package com.leetcode.easy.active;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int majorityElementV3(int[] nums) {
        Integer candidate = null;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int majorityElementV2(int[] nums) {
        return Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max((e1, e2) -> e1.getValue() - e2.getValue() > 0 ? 1 : -1)
                .map(Map.Entry::getKey).get();
    }

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(1)
     */
    public int majorityElementV1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
