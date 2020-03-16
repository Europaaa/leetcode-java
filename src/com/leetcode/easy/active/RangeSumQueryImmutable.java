package com.leetcode.easy.active;

/**
 * Range Sum Query - Immutable
 * Link: https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryImmutable {

    /**
     * Solution:
     * - Time: O(n) for init, O(1) for sumRange
     * - Space: O(n)
     */
    static class NumArrayV2 {

        private int[] sums;

        public NumArrayV2(int[] nums) {
            this.sums = new int[nums.length + 1];
            this.populateRangeSums(nums);
        }

        private void populateRangeSums(int[] nums) {
            this.sums[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                this.sums[i + 1] = this.sums[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return this.sums[j + 1] - this.sums[i];
        }
    }

    /**
     * Solution:
     * - Time: O(n^2) for init, O(1) for sumRange
     * - Space: O(n^2)
     */
    static class NumArrayV1 {

        private int[][] rangeSums;

        public NumArrayV1(int[] nums) {
            this.rangeSums = new int[nums.length][nums.length];
            this.populateRangeSums(nums);
        }

        private void populateRangeSums(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                this.rangeSums[i][i] = nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    this.rangeSums[i][j] = this.rangeSums[i][j - 1] + nums[j];
                }
            }
        }

        public int sumRange(int i, int j) {
            return this.rangeSums[i][j];
        }
    }
}
