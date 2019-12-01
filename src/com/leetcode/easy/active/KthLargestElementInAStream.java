package com.leetcode.easy.active;

import java.util.PriorityQueue;

/**
 * Kth Largest Element in a Stream
 * Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInAStream {

    static class KthLargestV2 {
        private int k;
        private PriorityQueue<Integer> minHeap;

        public KthLargestV2(int k, int[] nums) {
            this.k = k;

            this.minHeap = new PriorityQueue<>();
            for (Integer i : nums) {
                minHeap.add(i);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        public int add(int val) {
            minHeap.add(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }

    static class KthLargestV1 {

        static class TreeNode {
            int val;
            int count = 1;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }

            TreeNode incCount() {
                this.count++;
                return this;
            }
        }

        private int k;
        private TreeNode root;

        public KthLargestV1(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                this.root = insert(root, nums[i]);
            }
        }

        public int add(int val) {
            this.root = insert(this.root, val);
            return findKthLargest(this.root, this.k);
        }

        private static TreeNode insert(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            if (val < root.val) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
            return root.incCount();
        }

        private static int findKthLargest(TreeNode root, int k) {
            int count;
            if (root.right != null) {
                count = k - root.right.count - 1;
            } else {
                count = k - 1;
            }

            if (count == 0) {
                return root.val;
            }
            if (count > 0) {
                return findKthLargest(root.left, count);
            }
            return findKthLargest(root.right, k);
        }
    }
}
