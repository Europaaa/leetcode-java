package com.leetcode.easy.archived;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Minimum Index Sum of Two Lists
 * Link: https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
public class MinimumIndexSumOfTwoLists {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indices = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            indices.put(list1[i], i);
        }

        int minSum = Integer.MAX_VALUE;
        List<Object> choices = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (indices.containsKey(list2[i])) {
                int sum = indices.get(list2[i]) + i;
                if (sum < minSum) {
                    minSum = sum;

                    choices.clear();
                    choices.add(list2[i]);
                } else if (sum == minSum) {
                    choices.add(list2[i]);
                }
            }
        }
        return choices.toArray(new String[choices.size()]);
    }
}
