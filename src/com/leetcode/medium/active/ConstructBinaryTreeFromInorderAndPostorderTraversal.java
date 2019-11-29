package com.leetcode.medium.active;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     */
    public TreeNode buildTreeV3(int[] inorder, int[] postorder) {
        Map<Integer, Integer> indices = IntStream.range(0, inorder.length)
                .boxed()
                .collect(Collectors.toMap(i -> inorder[i], Function.identity()));

        return buildTreeV3(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, indices);
    }

    private TreeNode buildTreeV3(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> indices) {
        if (postEnd > postEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int i = indices.get(root.val);

        int numsLeft = i - inStart;
        root.left = buildTreeV3(inorder, inStart, i - 1, postorder, postStart, postStart + numsLeft - 1, indices);
        root.right = buildTreeV3(inorder, i + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, indices);

        return root;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n)
     */
    public TreeNode buildTreeV2(int[] inorder, int[] postorder) {
        return buildTreeV2(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }

    private TreeNode buildTreeV2(int[] inorder, int start, int end, int[] postorder, int index) {
        if (start > end || index < 0) {
            return null;
        }

        int v = postorder[index];

        int i = start;
        for (; i <= end && inorder[i] != v; i++) {
        }

        TreeNode root = new TreeNode(v);
        root.left = buildTreeV2(inorder, start, i - 1, postorder, index - (end - i + 1));
        root.right = buildTreeV2(inorder, i + 1, end, postorder, index - 1);
        return root;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n)
     */
    public TreeNode buildTreeV1(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if (n == 0) {
            return null;
        }

        int v = postorder[n - 1];

        int i = 0;
        for (; i < inorder.length && inorder[i] != v; i++) {
        }

        TreeNode root = new TreeNode(v);
        root.left = buildTreeV1(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
        root.right = buildTreeV1(Arrays.copyOfRange(inorder, i + 1, n), Arrays.copyOfRange(postorder, i, n - 1));
        return root;
    }
}
