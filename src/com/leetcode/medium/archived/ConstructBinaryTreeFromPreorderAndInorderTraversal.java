package com.leetcode.medium.archived;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
    public TreeNode buildTreeV2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indices = IntStream.range(0, inorder.length)
                .boxed()
                .collect(Collectors.toMap(i -> inorder[i], Function.identity()));

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, indices);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> indices) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int i = indices.get(root.val);

        int numsLeft = i - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, i - 1, indices);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, i + 1, inEnd, indices);

        return root;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n)
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) {
            return null;
        }

        int v = preorder[0];

        int i = 0;
        for (; i < inorder.length && inorder[i] != v; i++) {
        }

        TreeNode root = new TreeNode(v);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, n), Arrays.copyOfRange(inorder, i + 1, n));
        return root;
    }
}
