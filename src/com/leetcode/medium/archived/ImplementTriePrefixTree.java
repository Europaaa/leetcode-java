package com.leetcode.medium.archived;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement Trie (Prefix Tree)
 * Link: https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class ImplementTriePrefixTree {

    static class TrieV2 {

        static class Node {
            private char value;
            private boolean valid;
            private Node[] children;

            Node() {
                this.children = new Node[26];
            }

            Node(char value) {
                this.value = value;
                this.children = new Node[26];
            }
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public TrieV2() {
            this.root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();

            Node node = this.root;
            for (int i = 0; i < chars.length; i++) {
                int index = getIndex(chars[i]);
                if (node.children[index] == null) {
                    node.children[index] = new Node(chars[i]);
                }
                node = node.children[index];
            }
            node.valid = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node node = getNode(word);
            return node != null && node.valid;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return getNode(prefix) != null;
        }

        private int getIndex(char value) {
            return value - 'a';
        }

        private Node getNode(String prefix) {
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

    static class TrieV1 {

        static class Node {
            private char value;
            private boolean valid;
            private Map<Character, Node> children;

            Node() {
                this.children = new HashMap<>();
            }

            Node(char value) {
                this.value = value;
                this.children = new HashMap<>();
            }
        }

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public TrieV1() {
            this.root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] chars = word.toCharArray();

            Node node = this.root;
            for (int i = 0; i < chars.length; i++) {
                if (!node.children.containsKey(chars[i])) {
                    node.children.put(chars[i], new Node(chars[i]));
                }
                node = node.children.get(chars[i]);
            }
            node.valid = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node node = getNode(word);
            return node != null && node.valid;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return getNode(prefix) != null;
        }

        private Node getNode(String prefix) {
            char[] chars = prefix.toCharArray();

            Node node = this.root;
            for (int i = 0; i < chars.length; i++) {
                if (!node.children.containsKey(chars[i])) {
                    return null;
                }
                node = node.children.get(chars[i]);
            }
            return node;
        }
    }
}
