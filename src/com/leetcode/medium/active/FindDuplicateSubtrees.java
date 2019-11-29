package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find Duplicate Subtrees
 * Link: https://leetcode.com/problems/find-duplicate-subtrees/
 */
public class FindDuplicateSubtrees {

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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> duplicates = new ArrayList<>();
        lookup(root, new HashMap<>(), new HashMap<>(), duplicates);
        return duplicates;
    }

    private int lookup(TreeNode node, Map<Integer, Integer> counters, Map<String, Integer> uids, List<TreeNode> duplicates) {
        if (node == null) {
            return 0;
        }

        String key = node.val + "," + lookup(node.left, counters, uids, duplicates) + "," + lookup(node.right, counters, uids, duplicates);

        int uid;
        if (uids.containsKey(key)) {
            uid = uids.get(key);
        } else {
            uid = uids.size() + 1;
            uids.put(key, uid);
        }

        int count = counters.getOrDefault(uid, 0);
        if (count == 1) {
            duplicates.add(node);
        }
        counters.put(uid, count + 1);

        return uid;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n^2)
     */
    public List<TreeNode> findDuplicateSubtreesV1(TreeNode root) {
        List<TreeNode> duplicates = new ArrayList<>();
        collect(root, new HashMap<>(), duplicates);
        return duplicates;
    }

    private String collect(TreeNode node, Map<String, Integer> counters, List<TreeNode> duplicates) {
        if (node == null) {
            return "()";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("(").append(node.val)
                .append(collect(node.left, counters, duplicates))
                .append(collect(node.right, counters, duplicates))
                .append(")");

        String key = builder.toString();

        int count = counters.getOrDefault(key, 0);
        if (count == 1) {
            duplicates.add(node);
        }
        counters.put(key, count + 1);

        return key;
    }
}
