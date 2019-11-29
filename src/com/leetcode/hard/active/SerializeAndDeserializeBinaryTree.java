package com.leetcode.hard.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Serialize and Deserialize Binary Tree
 * Link: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class SerializeAndDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    private static final String NULL = "null";
    private static final String DELIMITER = ",";

    public String serializeV2(TreeNode root) {
        if (root == null) {
            return NULL;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(root.val).append(DELIMITER);
        builder.append(serializeV2(root.left)).append(DELIMITER);
        builder.append(serializeV2(root.right));
        return builder.toString();
    }

    public TreeNode deserializeV2(String data) {
        Queue<String> tokens = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return deserialize(tokens);
    }

    private TreeNode deserialize(Queue<String> tokens) {
        if (tokens.isEmpty()) {
            return null;
        }

        String token = tokens.poll();
        if (NULL.equals(token)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(token));
        node.left = deserialize(tokens);
        node.right = deserialize(tokens);
        return node;
    }

    // Encodes a tree to a single string.
    public String serializeV1(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<String> values = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean cont = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    values.add(NULL);
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    values.add(String.valueOf(node.val));

                    cont = cont || node.left != null || node.right != null;
                }
            }

            if (!cont) {
                break;
            }
        }
        return "[" + String.join(DELIMITER, values) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserializeV1(String data) {
        if ("[]".equals(data)) {
            return null;
        }

        String[] values = data.substring(1, data.length() - 1).split(DELIMITER);
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < values.length) {
            TreeNode node = queue.poll();

            if (node == null) {
                i = i + 2;
                continue;
            }

            if (NULL.equals(values[i])) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.valueOf(values[i]));
                queue.offer(node.left);
            }

            if (NULL.equals(values[i + 1])) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.valueOf(values[i + 1]));
                queue.offer(node.right);
            }

            i = i + 2;
        }
        return root;
    }
}
