package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Top k Frequent Elements
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequentElements {

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public List<Integer> topKFrequentV2(int[] nums, int k) {
        Map<Integer, Long> counters = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> (int) (counters.get(n1) - counters.get(n2)));
        for (int num : counters.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<Integer> topK = new ArrayList<>(heap);
        Collections.reverse(topK);
        return topK;
    }

    /**
     * Solution:
     * - Time: O(nlogn)
     * - Space: O(n)
     */
    public List<Integer> topKFrequentV1(int[] nums, int k) {
        Map<Integer, Long> counters = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Long, List<Integer>> groups = counters.keySet().stream()
                .collect(Collectors.groupingBy(counters::get, Collectors.toList()));

        Long[] frequencies = groups.keySet().stream().sorted().collect(Collectors.toList()).toArray(new Long[groups.size()]);

        List<Integer> topK = new ArrayList<>();
        for (int i = frequencies.length - 1; i >= 0; i--) {
            topK.addAll(groups.get(frequencies[i]));
            if (topK.size() >= k) {
                return topK;
            }
        }
        return topK;
    }
}
