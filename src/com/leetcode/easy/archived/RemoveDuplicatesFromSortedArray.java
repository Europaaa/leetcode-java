package com.leetcode.easy.archived;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Duplicates from Sorted Array
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Solution 2:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int removeDuplicatesV2(int[] values) {
        // i represents the pointer to the next value
        int n = 0;

        // j represents the pointer for the next value to examine
        for (int j = 0; j < values.length; j++) {
            int v = values[j];
            values[n++] = v;

            for (; j < values.length && values[j] == v; j++) {
            }
            j--;
        }

        return n;
    }

    /**
     * Solution 1:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int removeDuplicatesV1(int[] values) {
        Set<Integer> duplicates = new HashSet<>();

        int n = 0;
        for (int i = 0; i < values.length; i++) {
            if (!duplicates.contains(values[i])) {
                values[n++] = values[i];
            }
            duplicates.add(values[i]);
        }
        return n;
    }
}
