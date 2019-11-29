package com.leetcode.easy.active;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 * Design HashSet
 * Link: https://leetcode.com/problems/design-hashset/
 */
public class DesignHashSet {

    private static final int NUM_BUCKET = 1000;

    private LinkedList<Integer>[] buckets;

    /**
     * Initialize your data structure here.
     */
    public DesignHashSet() {
        this.buckets = (LinkedList[]) Array.newInstance(LinkedList.class, NUM_BUCKET);
    }

    public void add(int key) {
        int b = this.getBucket(key);

        if (this.buckets[b] == null) {
            this.buckets[b] = new LinkedList<>();
        }
        if (!this.buckets[b].contains(key)) {
            this.buckets[b].addLast(key);
        }
    }

    public void remove(int key) {
        int b = this.getBucket(key);

        if (this.buckets[b] == null) {
            return;
        }
        this.buckets[b].removeFirstOccurrence(key);
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int b = this.getBucket(key);

        if (this.buckets[b] == null) {
            return false;
        }
        return this.buckets[b].contains(key);
    }

    private int getBucket(int key) {
        return key % NUM_BUCKET;
    }
}
