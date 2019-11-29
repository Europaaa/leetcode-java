package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Open the Lock
 * Link: https://leetcode.com/problems/open-the-lock/
 */
public class OpenTheLock {

    private static final String INITIAL_STATE = "0000";

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        int moves = 0;
        queue.offer(INITIAL_STATE);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String state = queue.poll();
                if (visited.contains(state)) {
                    continue;
                }
                if (target.equals(state)) {
                    return moves;
                }
                visited.add(state);

                getNextStates(state).forEach(queue::offer);
            }
            moves++;
        }
        return -1;
    }

    private List<String> getNextStates(String state) {
        char[] digits = state.toCharArray();

        List<String> states = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            char digit = digits[i];

            digits[i] = digit == '9' ? '0' : (char) (digit + ((char) 1));
            states.add(String.valueOf(digits));

            digits[i] = digit == '0' ? '9' : (char) (digit - ((char) 1));
            states.add(String.valueOf(digits));

            digits[i] = digit;
        }
        return states;
    }
}
