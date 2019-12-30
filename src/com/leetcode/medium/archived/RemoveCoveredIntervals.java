package com.leetcode.medium.archived;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class RemoveCoveredIntervals {

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public int removeCoveredIntervals(int[][] inputs) {
        if (inputs.length == 0) {
            return 0;
        }

        int[][] intervals = Arrays.stream(inputs)
                .sorted(Comparator.comparingInt(inter -> inter[0]))
                .collect(Collectors.toList())
                .toArray(new int[0][]);

        int count = 0;
        for (int i = 0, j = 1; i < intervals.length && j < intervals.length; j++) {
            if (intervals[j][1] <= intervals[i][1]) {
                count++;
            } else {
                i = j;
            }
        }
        return intervals.length - count;
    }
}
