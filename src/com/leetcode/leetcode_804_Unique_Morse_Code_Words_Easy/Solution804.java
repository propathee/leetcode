package com.leetcode.leetcode_804_Unique_Morse_Code_Words_Easy;

import java.util.HashSet;
import java.util.Set;

abstract class Solution804 {
    public abstract int uniqueMorseRepresentations(String[] words);

    static Solution804 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution804 {
        private static final String[] DICT = {".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...",
            "-","..-","...-",".--","-..-","-.--","--.."};

        @Override
        public int uniqueMorseRepresentations(String[] words) {
            Set<String> set = new HashSet<>();
            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                for (char c : word.toCharArray()) {
                    sb.append(DICT[c - 'a']);
                }
                set.add(sb.toString());
            }
            return set.size();
        }
    }
}
