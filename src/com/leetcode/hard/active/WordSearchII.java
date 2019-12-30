package com.leetcode.hard.active;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Search II
 * Link: https://leetcode.com/problems/word-search-ii/
 */
public class WordSearchII {

    private static final List<int[]> ADJACENT_CELLS = Arrays.asList(new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, -1}, new int[]{0, 1});

    /**
     * Solution:
     * - Time: O(mnk(4^l)) = max(O(kl), O(mnk(4^l)))
     * - Space: O(kl) = max(O(l), O(kl))
     * where m is the number of columns in the board and n is the number of rows of the board, k is the number of words,
     * and l is the max length of the words.
     */
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        Arrays.stream(words).forEach(trie::insert);

        Set<String> wordsFound = new HashSet<>();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                boolean[][] visited = new boolean[board.length][board[0].length];

                wordsFound.addAll(backtrace(board, x, y, trie.root, "", visited));
            }
        }
        return new ArrayList<>(wordsFound);
    }

    private Set<String> backtrace(char[][] board, int x, int y, Trie.Node node, String prefix, boolean[][] visited) {
        Set<String> words = new HashSet<>();

        char c = board[y][x];
        node = node.children[c - 'a'];

        if (node == null) {
            return words;
        }
        if (node.valid) {
            words.add(prefix + node.value);
        }

        visited[y][x] = true;
        for (int[] delta : ADJACENT_CELLS) {
            if (!isValid(visited, x + delta[0], y + delta[1])) {
                continue;
            }
            words.addAll(backtrace(board, x + delta[0], y + delta[1], node, prefix + node.value, visited));
        }
        visited[y][x] = false;
        return words;
    }

    private boolean isValid(boolean[][] visited, int x, int y) {
        return y >= 0 && y < visited.length && x >= 0 && x < visited[0].length && !visited[y][x];
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

        private int getIndex(char value) {
            return value - 'a';
        }
    }
}

