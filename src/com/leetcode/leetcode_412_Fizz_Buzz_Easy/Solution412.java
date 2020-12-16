package com.leetcode.leetcode_412_Fizz_Buzz_Easy;

import java.util.ArrayList;
import java.util.List;

public abstract class Solution412 {
    /**
     * Write a program that outputs the string representation of numbers from 1 to n.
     * <p>
     * But for multiples of three it should output “Fizz” instead of the number,
     * and for the multiples of five output “Buzz”.
     * For numbers which are multiples of both three and five output “FizzBuzz”.
     */
    public abstract List<String> fizzBuzz(int n);

    static Solution412 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution412 {
        @Override
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (i % 15 == 0) {
                    res.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    res.add("Fizz");
                } else if (i % 5 == 0) {
                    res.add("Buzz");
                } else {
                    res.add(String.valueOf(i));
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution412 {
        @Override
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();
            for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
                fizz++;
                buzz++;
                if (fizz == 3 && buzz == 5) {
                    res.add("FizzBuzz");
                    fizz = 0;
                    buzz = 0;
                } else if (fizz == 3) {
                    res.add("Fizz");
                    fizz = 0;
                } else if (buzz == 5) {
                    res.add("Buzz");
                    buzz = 0;
                } else {
                    res.add(String.valueOf(i));
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution412 {
        @Override
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList<>();
            for (int i = 1, fizz = 3, buzz = 5; i <= n; i++) {
                if (i == fizz && i == buzz) {
                    res.add("FizzBuzz");
                    fizz += 3;
                    buzz += 5;
                } else if (i == fizz) {
                    res.add("Fizz");
                    fizz += 3;
                } else if (i == buzz) {
                    res.add("Buzz");
                    buzz += 5;
                } else {
                    res.add(String.valueOf(i));
                }
            }
            return res;
        }
    }
}
