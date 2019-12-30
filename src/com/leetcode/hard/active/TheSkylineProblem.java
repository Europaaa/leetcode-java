package com.leetcode.hard.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The Skyline Problem
 * Link: https://leetcode.com/problems/the-skyline-problem/
 */
public class TheSkylineProblem {

    private static final int BUILDING_START = 0;
    private static final int BUILDING_END = 1;
    private static final int BUILDING_HEIGHT = 2;

    private static final int SKYLINE_POSITION = 0;
    private static final int SKYLINE_HEIGHT = 1;

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public List<List<Integer>> getSkylineV2(int[][] buildings) {
        return getSkyline(buildings, 0, buildings.length - 1);
    }

    private LinkedList<List<Integer>> getSkyline(int[][] buildings, int start, int end) {
        LinkedList<List<Integer>> skyline = new LinkedList<>();
        if (start > end) {
            return skyline;
        }

        if (start == end) {
            int[] building = buildings[start];
            skyline.add(Arrays.asList(building[BUILDING_START], building[BUILDING_HEIGHT]));
            skyline.add(Arrays.asList(building[BUILDING_END], 0));
            return skyline;
        }

        int middle = start + (end - start) / 2;

        LinkedList<List<Integer>> skyline1 = getSkyline(buildings, start, middle);
        LinkedList<List<Integer>> skyline2 = getSkyline(buildings, middle + 1, end);

        int height1 = 0;
        int height2 = 0;
        while (!skyline1.isEmpty() && !skyline2.isEmpty()) {
            List<Integer> point1 = skyline1.peek();
            List<Integer> point2 = skyline2.peek();

            int position1 = point1.get(SKYLINE_POSITION);
            int position2 = point2.get(SKYLINE_POSITION);

            if (position1 <= position2) {
                height1 = point1.get(SKYLINE_HEIGHT);
                skyline1.poll();
            }

            if (position1 >= position2) {
                height2 = point2.get(SKYLINE_HEIGHT);
                skyline2.poll();
            }

            int position = Math.min(position1, position2);
            int height = Math.max(height1, height2);

            if (skyline.isEmpty() || height != skyline.peekLast().get(SKYLINE_HEIGHT)) {
                skyline.add(Arrays.asList(position, height));
            }
        }

        skyline.addAll(skyline1);
        skyline.addAll(skyline2);
        return skyline;
    }


    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public List<List<Integer>> getSkylineV1(int[][] buildings) {
        Map<Integer, List<int[]>> points = new TreeMap<>();
        for (int[] building : buildings) {
            points.putIfAbsent(building[BUILDING_START], new LinkedList<>());
            points.putIfAbsent(building[BUILDING_END], new LinkedList<>());
            points.get(building[BUILDING_START]).add(building);
            points.get(building[BUILDING_END]).add(building);
        }

        List<List<Integer>> skyline = new ArrayList<>();

        TreeMap<Integer, Integer> heights = new TreeMap<>(Collections.reverseOrder());
        for (Integer point : points.keySet()) {
            for (int[] building : points.get(point)) {
                if (point == building[BUILDING_START]) {
                    int height = building[BUILDING_HEIGHT];
                    int counter = heights.getOrDefault(height, 0);
                    heights.put(height, counter + 1);
                } else {
                    int height = building[BUILDING_HEIGHT];
                    int counter = heights.getOrDefault(height, 0);
                    if (counter > 1) {
                        heights.put(height, counter - 1);
                    } else {
                        heights.remove(height);
                    }
                }
            }

            if (heights.isEmpty()) {
                skyline.add(Arrays.asList(point, 0));
            } else {
                int height = heights.firstKey();
                if (skyline.isEmpty() || skyline.get(skyline.size() - 1).get(SKYLINE_HEIGHT) != height) {
                    skyline.add(Arrays.asList(point, height));
                }
            }
        }
        return skyline;
    }
}
