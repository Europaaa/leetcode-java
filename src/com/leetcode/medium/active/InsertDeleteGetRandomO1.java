package com.leetcode.medium.active;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Insert Delete GetRandom O(1)
 * Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class InsertDeleteGetRandomO1 {

    private List<Integer> values;
    private Map<Integer, Integer> indices;

    private Random random;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1() {
        this.values = new ArrayList<>();
        this.indices = new HashMap<>();

        this.random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (this.indices.containsKey(val)) {
            return false;
        }
        this.values.add(val);
        this.indices.put(val, this.values.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (this.indices.containsKey(val)) {
            int i = this.indices.get(val);

            int last = this.values.get(this.values.size() - 1);
            this.values.set(i, last);
            this.indices.put(last, i);

            this.values.remove(this.values.size() - 1);
            this.indices.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int i = this.random.nextInt(this.values.size());
        return this.values.get(i);
    }
}
