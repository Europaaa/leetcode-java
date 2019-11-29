package com.leetcode.easy.active;

import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle an Array
 * Link:
 */
public class ShuffleAnArray {

    private int[] seeds;
    private int[] nums;

    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.seeds = nums;
        this.nums = Arrays.copyOf(this.seeds, this.seeds.length);

        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.nums = Arrays.copyOf(this.seeds, this.seeds.length);
        return this.seeds;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < this.nums.length; i++) {
            int j = i + random.nextInt(this.nums.length - i);

            int v = this.nums[i];
            this.nums[i] = this.nums[j];
            this.nums[j] = v;
        }
        return this.nums;
    }
}
