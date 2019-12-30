package com.leetcode.medium.archived;

import java.util.Iterator;
import java.util.Optional;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Optional<Integer> next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        this.next = Optional.empty();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (this.next.isPresent()) {
            return this.next.get();
        }
        this.next = Optional.of(this.iterator.next());
        return this.next.get();
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (this.next.isPresent()) {
            Integer next = this.next.get();
            this.next = Optional.empty();
            return next;
        }
        return this.iterator.next();
    }

    @Override
    public boolean hasNext() {
        return this.next.isPresent() || this.iterator.hasNext();
    }
}
