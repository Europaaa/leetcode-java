package com.leetcode.hard.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Palindrome Pairs
 * Link: https://leetcode.com/problems/palindrome-pairs/
 */
public class PalindromePairs {

    static class TrieNode {
        // Stores the index of the word from the input
        private int id;
        // Stores indices of the words below which (in the trie) can form a palindrome
        private List<Integer> list;
        private TrieNode[] children;

        TrieNode() {
            this.id = -1;
            this.list = new ArrayList<>();
            this.children = new TrieNode[26];
        }

        public boolean valid() {
            return this.id >= 0;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();

        TrieNode root = new TrieNode();

        // Assume A and B are two words from the word list, and AB is a palindrome.
        // Then it can be one of the two cases:
        // - A is a prefix of reversed B, and the rest of reversed B can form a palindrome
        // - B is a prefix of reversed A, and the rest of reversed A can form a palindrome

        for (int i = 0; i < words.length; i++) {
            insert(root, getReverse(words[i]), i);
        }
        for (int i = 0; i < words.length; i++) {
            pairs.addAll(search(words, i, root));
        }

        return pairs;
    }

    private void insert(TrieNode root, String word, int id) {
        char[] chars = word.toCharArray();

        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            if (isPalindrome(word, i, chars.length - 1)) {
                node.list.add(id);
            }
            node = node.children[index];
        }

        node.id = id;
        node.list.add(id);
    }

    private List<List<Integer>> search(String[] words, int i, TrieNode root) {
        List<List<Integer>> pairs = new ArrayList<>();

        char[] chars = words[i].toCharArray();

        TrieNode node = root;
        for (int j = 0; j < chars.length; j++) {
            if (node.valid() && node.id != i && isPalindrome(words[i], j, chars.length - 1)) {
                pairs.add(Arrays.asList(i, node.id));
            }

            node = node.children[chars[j] - 'a'];
            if (node == null) {
                return pairs;
            }
        }

        for (int j : node.list) {
            if (i == j) {
                continue;
            }
            pairs.add(Arrays.asList(i, j));
        }
        return pairs;
    }

    private String getReverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private boolean isPalindrome(String word, int i, int j) {
        char[] chars = word.toCharArray();
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Solution:
     * - Time: O(kn^2)
     * - Space: O(1)
     * where n is the number of words and k is the max length of words
     */
    public List<List<Integer>> palindromePairsV1(String[] words) {
        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindrome(words[i] + words[j])) {
                    pairs.add(Arrays.asList(i, j));
                }
                if (isPalindrome(words[j] + words[i])) {
                    pairs.add(Arrays.asList(j, i));
                }
            }
        }
        return pairs;
    }

    private boolean isPalindrome(String value) {
        char[] chars = value.toCharArray();

        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }
}
