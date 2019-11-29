package com.leetcode.easy.archived;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Intersection of Two Arrays II
 * Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArraysII {

    /**
     * Solution 2: Sorting
     * - Time: O(n)
     * - Space: O(n)
     */
    public int[] intersectV2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> common = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
             if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                 common.add(nums1[i]);
                 i++;
                 j++;
             }
        }

        int[] result = new int[common.size()];
        for (int k = 0; k < common.size(); k++) {
            result[k] = common.get(k);
        }
        return result;
    }

    /**
     * Solution 1: Hash Table
     * - Time: O(n)
     * - Space: O(n)
     */
    public int[] intersectV1(int[] nums1, int[] nums2) {
        Map<Integer, Long> counters = Arrays.stream(nums2).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> common = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            int v = nums1[i];
            Long counter = counters.getOrDefault(v, 0l);
            if (counter > 0) {
                common.add(v);
                counters.put(v, counter - 1);
            }
        }

        int[] result = new int[common.size()];
        for (int i = 0; i < common.size(); i++) {
            result[i] = common.get(i);
        }
        return result;
    }
}
