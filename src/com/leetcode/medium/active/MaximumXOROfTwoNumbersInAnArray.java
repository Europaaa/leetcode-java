package com.leetcode.medium.active;

/**
 * Maximum XOR of Two Numbers in an Array
 * Link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class MaximumXOROfTwoNumbersInAnArray {

    private static final int NUM_BITS = 32;

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public int findMaximumXORV2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Trie trie = new Trie();
        for (int num : nums) {
            // Insert the 32-bit binary representation of each number
            trie.insert(getBits(num));
        }

        int maxXOR = 0;
        for (int num : nums) {
            maxXOR = Math.max(getMaximumXOR(trie, num), maxXOR);
        }
        return maxXOR;
    }

    private boolean[] getBits(int num) {
        boolean[] bits = new boolean[NUM_BITS];
        for (int i = NUM_BITS - 1; i >= 0; i--) {
            bits[NUM_BITS - i - 1] = ((1 << i) & num) != 0;
        }
        return bits;
    }

    private int getMaximumXOR(Trie trie, int num) {
        Trie.Node node = trie.root;
        int maxXOR = 0;

        for (int i = NUM_BITS - 1; i >= 0; i--) {
            int bit = (num >> i) & 1;

            // When the two numbers have different bits on the same position, the XOR results is maximized.
            // Otherwise, it results to an 0 at that position.
            if (node.children[1 - bit] != null) {
                node = node.children[1 - bit];
                maxXOR += 1 << i;
            } else {
                node = node.children[bit];
                maxXOR += 0 << i;
            }
        }
        return maxXOR;
    }

    static class Trie {

        static class Node {
            private boolean valid;
            private Node[] children;

            Node() {
                this.children = new Node[2];
            }
        }

        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(boolean[] bits) {
            Node node = this.root;
            for (int i = 0; i < bits.length; i++) {
                int index = bits[i] ? 1 : 0;
                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }
                node = node.children[index];
            }
            node.valid = true;
        }
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(1)
     */
    public int findMaximumXORV1(int[] nums) {
        int maxXOR = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                maxXOR = Math.max(nums[i] ^ nums[j], maxXOR);
            }
        }
        return maxXOR;
    }
}
