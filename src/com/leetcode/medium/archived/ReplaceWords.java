package com.leetcode.medium.archived;

import java.util.List;

/**
 * Replace Words
 * Link: https://leetcode.com/problems/replace-words/
 */
public class ReplaceWords {

    /**
     * Solution:
     * - Time: O(n)
     * - Space: O(n)
     * where n is the total number of characters among all root words
     */
    public String replaceWords(List<String> roots, String sentence) {
        Trie trie = new Trie();
        roots.forEach(trie::insert);

        String[] tokens = sentence.split(" ");
        String[] replacements = new String[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String prefix = trie.getPrefix(tokens[i]);
            if (prefix == null || prefix.isEmpty()) {
                replacements[i] = tokens[i];
            } else {
                replacements[i] = prefix;
            }
        }
        return String.join(" ", replacements);
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

        public String getPrefix(String word) {
            char[] chars = word.toCharArray();

            Node node = this.root;
            for (int i = 0; i < chars.length; i++) {
                if (node.valid) {
                    return word.substring(0, i);
                }

                int index = getIndex(chars[i]);
                if (node.children[index] == null) {
                    return node.valid ? word.substring(0, i) : null;
                }
                node = node.children[index];
            }
            return word;
        }

        private int getIndex(char value) {
            return value - 'a';
        }
    }
}
