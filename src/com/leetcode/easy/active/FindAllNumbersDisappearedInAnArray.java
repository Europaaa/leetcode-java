package com.leetcode.easy.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find All Numbers Disappeared in an Array
 * Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class FindAllNumbersDisappearedInAnArray {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public List<Integer> findDisappearedNumbersV2(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Mark the numbers we've seen as negative
            int v = Math.abs(nums[i]) - 1;
            nums[v] = -Math.abs(nums[v]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missingNumbers.add(i + 1);
            }
        }
        return missingNumbers;
    }

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(1)
     */
    public List<Integer> findDisappearedNumbersV1(int[] nums) {
        Arrays.sort(nums);

        List<Integer> missingNumbers = new ArrayList<>();

        int j = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < j) {
                continue;
            }

            if (nums[i] == j) {
                j++;
                continue;
            }

            for (; j < nums[i]; j++) {
                missingNumbers.add(j);
            }
            j++;
        }

        while (j <= nums.length) {
            missingNumbers.add(j++);
        }
        return missingNumbers;
    }
}
