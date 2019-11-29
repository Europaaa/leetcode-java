package com.leetcode.easy.archived;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 * Design HashMap
 * Link: https://leetcode.com/problems/design-hashmap/
 */
public class DesignHashMap {

    private static final int NUM_BUCKET = 1000;

    private LinkedList<int[]>[] buckets;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        this.buckets = (LinkedList[]) Array.newInstance(LinkedList.class, NUM_BUCKET);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int b = this.getBucket(key);

        if (this.buckets[b] == null) {
            this.buckets[b] = new LinkedList<>();
        }

        for (int[] pair : this.buckets[b]) {
            if (pair[0] == key) {
                pair[1] = value;
                return;
            }
        }
        this.buckets[b].addLast(new int[] {key, value});
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int b = this.getBucket(key);

        if (this.buckets[b] == null) {
            return -1;
        }

        for (int[] pair : this.buckets[b]) {
            if (pair[0] == key) {
                return pair[1];
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int b = this.getBucket(key);

        if (this.buckets[b] == null) {
            return;
        }

        this.buckets[b].removeIf(pair -> pair[0] == key);
    }

    private int getBucket(int key) {
        return key % NUM_BUCKET;
    }
}
