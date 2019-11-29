package com.leetcode.medium.active;

import java.util.Arrays;

/**
 * Jump Game
 * Link: https://leetcode.com/problems/jump-game/
 */
public class JumpGame {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(1)
     */
    public boolean canJumpV2(int[] nums) {
        int n = nums.length;

        int i = 0;
        for (int reach = 0; i < n && i <= reach; i++) {
            reach = Math.max(reach, i + nums[i]);
        }
        return i == n;
    }

    /**
     * Solution:
     * - Time: O(n^2)
     * - Space: O(n)
     */
    public boolean canJumpV1(int[] nums) {
        int n = nums.length;

        boolean[] reachable = new boolean[n];
        Arrays.fill(reachable, false);

        reachable[0] = true;
        for (int i = 0; i < n; i++) {
            if (!reachable[i]) {
                continue;
            }

            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                reachable[i + j] = true;
            }
        }
        return reachable[n - 1];
    }
}
