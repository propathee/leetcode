package com.leetcode.leetcode_557_Reverse_Words_in_a_String_III_Easy;

abstract class Solution557 {
    public abstract String reverseWords(String s);

    static Solution557 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution557 {
        @Override
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
            return String.join(" ", words);
        }
    }

    private static class S2 extends Solution557 {
        @Override
        public String reverseWords(String s) {
            StringBuilder sentence = new StringBuilder();
            StringBuilder word = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    sentence.append(word.reverse());
                    sentence.append(c);
                    word = new StringBuilder();
                } else {
                    word.append(c);
                }
            }
            return sentence.append(word.reverse()).toString();
        }
    }

    private static class S3 extends Solution557 {
        @Override
        public String reverseWords(String s) {
            StringBuilder sentence = new StringBuilder();
            int i = 0;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    sentence.append(c);
                    i = sentence.length();
                } else {
                    sentence.insert(i, c);
                }
            }
            return sentence.toString();
        }
    }

    private static class S4 extends Solution557 {
        @Override
        public String reverseWords(String s) {
            char[] chars = s.toCharArray();
            int l = 0;
            for (int r = 0; r < chars.length; r++) {
                if (chars[r] == ' ') {
                    swap(chars, l, r - 1);
                    l = r + 1;
                }
            }
            swap(chars, l, chars.length - 1);
            return new String(chars);
        }

        private void swap(char[] chars, int l, int r) {
            for (; l < r; l++, r--) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
            }
        }
    }
}
