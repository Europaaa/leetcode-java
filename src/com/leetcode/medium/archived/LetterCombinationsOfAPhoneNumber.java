package com.leetcode.medium.archived;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Letter Combinations of a Phone Number
 * Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

    private static final Map<Character, List<Character>> LETTER_MAPPING = new HashMap<>();

    {
        LETTER_MAPPING.put('2', Arrays.asList('a', 'b', 'c'));
        LETTER_MAPPING.put('3', Arrays.asList('d', 'e', 'f'));
        LETTER_MAPPING.put('4', Arrays.asList('g', 'h', 'i'));
        LETTER_MAPPING.put('5', Arrays.asList('j', 'k', 'l'));
        LETTER_MAPPING.put('6', Arrays.asList('m', 'n', 'o'));
        LETTER_MAPPING.put('7', Arrays.asList('p', 'q', 'r', 's'));
        LETTER_MAPPING.put('8', Arrays.asList('t', 'u', 'v'));
        LETTER_MAPPING.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    /**
     * Solution:
     * - Time: O(3^n 4^m)
     * - Space: O(3^n 4^m)
     * where n is the number of digits in the input that maps to 3 letters and m is the number of digits in the input that
     * maps to 4 letters
     */
    public List<String> letterCombinations(String digits) {
        return letterCombinations(digits.toCharArray(), 0);
    }

    private List<String> letterCombinations(char[] digits, int i) {
        if (digits.length == 0) {
            return new ArrayList<>();
        }
        if (i == digits.length - 1) {
            return LETTER_MAPPING.get(digits[i]).stream().map(String::valueOf).collect(Collectors.toList());
        }

        List<String> strings = letterCombinations(digits, i + 1);

        List<String> results = new ArrayList<>();
        for (Character c : LETTER_MAPPING.get(digits[i])) {
            strings.stream().map(s -> c + s).forEach(results::add);
        }
        return results;
    }
}
