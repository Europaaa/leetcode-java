package com.leetcode.medium.archived;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Permutations:
 * Link:
 */
public class Permutations {

    /**
     * Solution:
     * - Time: O(n n!)
     * - Space: O(n)
     */
    public List<List<Integer>> permuteV2(int[] nums) {
        return backtrace(nums, new ArrayList<>());
    }

    private List<List<Integer>> backtrace(int[] nums, List<Integer> numbers) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums.length == numbers.size()) {
            results.add(numbers);
            return results;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isValid(numbers, nums[i])) {
                continue;
            }

            List<Integer> newNumbers = new ArrayList<>();
            newNumbers.addAll(numbers);
            newNumbers.add(nums[i]);

            results.addAll(backtrace(nums, newNumbers));
        }
        return results;
    }

    private boolean isValid(List<Integer> numbers, int number) {
        return !numbers.contains(number);
    }

    /**
     * Solution:
     * - Time: O(n!)
     * - Space: O(n)
     */
    public List<List<Integer>> permuteV1(int[] nums) {
        if (nums.length == 0) {
            return Arrays.asList();
        }
        if (nums.length == 1) {
            List<Integer> numbers = new ArrayList<>();
            numbers.add(nums[0]);
            return Arrays.asList(numbers);
        }

        List<List<Integer>> permutations = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = i;
            int[] numbers = IntStream.range(0, nums.length)
                    .filter(j -> j != target)
                    .map(j -> nums[j])
                    .toArray();

            permuteV1(numbers).stream()
                    .map(permutation -> {
                        permutation.add(nums[target]);
                        return permutation;
                    })
                    .forEach(permutations::add);
        }
        return permutations;
    }
}
