package com.leetcode.easy.active;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy Number
 * Link: https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    /**
     * Solution:
     * - Time: O(log_n)
     * - Space: O(1)
     */
    public boolean isHappyV2(int n) {
        int num1 = n;
        int num2 = getSumOfDigits(n);

        while (num1 != 1 && num1 != num2) {
            num1 = getSumOfDigits(num1);
            num2 = getSumOfDigits(getSumOfDigits(num2));
        }
        return num1 == 1;
    }

    /**
     * Solution:
     * - Time: O(log_n)
     * - Space: O(log_n)
     */
    public boolean isHappyV1(int n) {
        Set<Integer> numbers = new HashSet<>();

        int number = n;
        while (!numbers.contains(number)) {
            numbers.add(number);

            number = getSumOfDigits(number);
            if (number == 1) {
                return true;
            }
        }
        return false;
    }

    private int getSumOfDigits(int n) {
        int sum = 0;

        int number = n;
        while (number > 0) {
            int digit = number % 10;
            sum += digit * digit;

            number = number / 10;
        }
        return sum;
    }
}
