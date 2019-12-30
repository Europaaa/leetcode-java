package com.leetcode.medium.archived;

import java.util.Arrays;
import java.util.Objects;

/**
 * Add and Search Word
 * Link: https://leetcode.com/problems/add-and-search-word-data-structure-design/
 */
public class AddAndSearchWord {

    static class WordDictionary {

        private Trie trie;

        public WordDictionary() {
            this.trie = new Trie();
        }

        /**
         * Solution:
         * - Time: O(n)
         * - Space: O(n)
         */
        public void addWord(String word) {
            this.trie.insert(word);
        }

        /**
         * Solution:
         * - Time: O(26^n)
         * - Space: O(1)
         */
        public boolean search(String word) {
            return this.trie.search(word);
        }

        static class Trie {

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

            public Trie() {
                this.root = new Node();
            }

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

            public boolean search(String regex) {
                Node node = getNode(this.root, regex.toCharArray(), 0);
                return node != null && node.valid;
            }

            private int getIndex(char value) {
                return value - 'a';
            }

            private Node getNode(Node root, char[] chars, int start) {
                Node node = root;
                for (int i = start; i < chars.length; i++) {
                    if (chars[i] == '.') {
                        int j = i + 1;
                        return Arrays.stream(node.children)
                                .filter(Objects::nonNull)
                                .map(child -> this.getNode(child, chars, j))
                                .filter(Objects::nonNull)
                                .filter(child -> child.valid)
                                .findAny().orElse(null);
                    }

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
