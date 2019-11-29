package com.leetcode.easy.archived;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Contains Duplicate
 * Link: https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Object> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.size() != nums.length;
    }
}
