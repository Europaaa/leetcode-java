package com.leetcode.medium.archived;

import java.util.List;
import java.util.Stack;

/**
 * Keys and Rooms
 * Link: https://leetcode.com/problems/keys-and-rooms/
 */
public class KeysAndRooms {

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n)
     */
    public boolean canVisitAllRoomsV2(List<List<Integer>> rooms) {
        int n = rooms.size();
        if (n == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        stack.add(0);
        visited[0] = true;

        while (!stack.isEmpty()) {
            int room = stack.pop();
            for (Integer r : rooms.get(room)) {
                if (!visited[r]) {
                    visited[r] = true;
                    stack.add(r);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n^2)
     */
    public boolean canVisitAllRoomsV1(List<List<Integer>> rooms) {
        int n = rooms.size();
        if (n == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];

        stack.addAll(rooms.get(0));
        visited[0] = true;

        while (!stack.isEmpty()) {
            int room = stack.pop();
            if (visited[room]) {
                continue;
            }

            stack.addAll(rooms.get(room));
            visited[room] = true;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
