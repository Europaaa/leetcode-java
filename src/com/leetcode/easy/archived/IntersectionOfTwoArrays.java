package com.leetcode.easy.archived;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Intersection of Two Arrays
 * Link: https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).filter(set1::contains)
                .boxed()
                .collect(Collectors.toSet());

        int[] intersection = new int[set2.size()];
        int i = 0;
        for (Integer v : set2) {
            intersection[i++] = v;
        }
        return intersection;
    }
}
