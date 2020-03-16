package com.leetcode.easy.archived;

/**
 * Decompress Run-Length Encoded List
 * Link: Decompress Run-Length Encoded List
 */
public class DecompressRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        int length = 0;
        for (int i = 0; i < nums.length; i += 2) {
            length += nums[i];
        }

        int[] decoded = new int[length];
        int p = 0;

        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                decoded[p++] = nums[i + 1];
            }
        }
        return decoded;
    }
}
