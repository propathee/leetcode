package com.leetcode.leetcode_500_Keyboard_Row_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Solution500 {
    /**
     * Given a List of words, return the words that can be typed using letters of alphabet
     * on only one row's of American keyboard like the image below.
     * <P>
     * You may use one character in the keyboard more than once.
     * @param words You may assume the input string will only contain letters of alphabet.
     * @return String[]
     */
    public abstract String[] findWords(String[] words);

    static Solution500 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution500 {
        private static final List<String> ROWS = Arrays.asList(
            "qwertyuiop", "asdfghjkl", "zxcvbnm");

        @Override
        public String[] findWords(String[] words) {
            List<String> res = new ArrayList<>();
            out: for (String w : words) {
                String w1 = w.toLowerCase();
                for (String row : ROWS) {
                    if (row.contains(String.valueOf(w1.charAt(0)))) {
                        for (char c : w1.toCharArray()) {
                            if (!row.contains(String.valueOf(c))) {
                                continue out;
                            }
                        }
                        res.add(w);
                    }
                }
            }
            return res.toArray(new String[0]);
        }
    }

    private static class S2 extends Solution500 {
        @Override
        public String[] findWords(String[] words) {
            return Arrays.stream(words)
                .filter(w -> w.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*"))
                .toArray(String[]::new);
        }
    }

    private static class S3 extends Solution500 {
        @Override
        public String[] findWords(String[] words) {
            String[] rows = new String[] {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
            int[] dict = new int[26];
            for (int i = 0; i < rows.length; i++) {
                for (char c : rows[i].toCharArray()) {
                    dict[c - 'a'] = i;
                }
            }
            List<String> res = new ArrayList<>();
            for (String word : words) {
                String w = word.toLowerCase();
                String row = rows[dict[w.charAt(0) - 'a']];
                boolean found = true;
                for (char c : w.toCharArray()) {
                    if (!row.contains(String.valueOf(c))) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    res.add(word);
                }
            }
            return res.toArray(new String[0]);
        }
    }
}
