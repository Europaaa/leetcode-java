package com.leetcode.medium.active;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Map Sum Pairs
 * Link: https://leetcode.com/problems/map-sum-pairs/
 */
public class MapSum {

    static class MapSumV2 {
        Map<String, Integer> prefix;
        Map<String, Integer> score;

        public MapSumV2() {
            prefix = new HashMap();
            score = new HashMap();
        }

        /**
         * Solution:
         * - Time: O(n^2)
         * - Space: O(n)
         * where n is the number of characters in the key
         */
        public void insert(String key, int val) {
            prefix.put(key, val);

            char[] chars = key.toCharArray();
            int delta = val - prefix.getOrDefault(key, 0);

            String prefix = "";
            for (char c: chars) {
                prefix += c;
                score.put(prefix, score.getOrDefault(prefix, 0) + delta);
            }
        }

        /**
         * Solution:
         * - Time: O(1)
         * - Space: O(1)
         */
        public int sum(String prefix) {
            return score.getOrDefault(prefix, 0);
        }
    }

    static class MapSumV1 {
        private Trie trie;

        public MapSumV1() {
            this.trie = new Trie();
        }

        /**
         * Solution:
         * - Time: O(n)
         * - Space: O(n)
         * where n is the number of characters in the key
         */
        public void insert(String key, int val) {
            this.trie.insert(key, val);
        }

        /**
         * Solution:
         * - Time: O(n)
         * - Space: O(n)
         * where n is the number of characters in the key
         */
        public int sum(String prefix) {
            Trie.Node node = this.trie.getNode(prefix);
            return sum(node);
        }

        private int sum(Trie.Node node) {
            if (node == null) {
                return 0;
            }
            int sum = node.number.orElse(0);
            return sum + Arrays.stream(node.children).mapToInt(this::sum).sum();
        }

        static class Trie {

            static class Node {
                private char value;
                private Optional<Integer> number;
                private Node[] children;

                Node() {
                    this.children = new Node[26];
                }

                Node(char value) {
                    this.value = value;
                    this.number = Optional.empty();
                    this.children = new Node[26];
                }
            }

            private Node root;

            public Trie() {
                this.root = new Node();
            }

            public void insert(String word, int number) {
                char[] chars = word.toCharArray();

                Node node = this.root;
                for (int i = 0; i < chars.length; i++) {
                    int index = getIndex(chars[i]);
                    if (node.children[index] == null) {
                        node.children[index] = new Node(chars[i]);
                    }
                    node = node.children[index];
                }
                node.number = Optional.of(number);
            }

            private int getIndex(char value) {
                return value - 'a';
            }

            public Node getNode(String prefix) {
                char[] chars = prefix.toCharArray();

                Node node = this.root;
                for (int i = 0; i < chars.length; i++) {
                    int index = getIndex(chars[i]);
                    if (node.children[index] == null) {
                        return null;
                    }
                    node = node.children[index];
                }
                return node;
            }
        }
    }
}
