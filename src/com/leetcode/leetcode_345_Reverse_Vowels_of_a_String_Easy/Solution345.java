package com.leetcode.leetcode_345_Reverse_Vowels_of_a_String_Easy;

public class Solution345 {
    public String reverseVowels_1(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i < j && !vowels.contains(String.valueOf(chars[i]))) {
                i++;
            }
            while (i < j && !vowels.contains(String.valueOf(chars[j]))) {
                j--;
            }
            if (i != j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
        return String.valueOf(chars);
    }

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j;) {
            if (!vowels.contains(String.valueOf(chars[i]))) {
                i++;
                continue;
            }
            if (!vowels.contains(String.valueOf(chars[j]))) {
                j--;
                continue;
            }
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
