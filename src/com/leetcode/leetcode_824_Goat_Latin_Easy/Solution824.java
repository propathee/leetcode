package com.leetcode.leetcode_824_Goat_Latin_Easy;

abstract class Solution824 {
    public abstract String toGoatLatin(String S);

    static Solution824 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution824 {
        @Override
        public String toGoatLatin(String S) {
            StringBuilder sentence = new StringBuilder();
            StringBuilder suffix = new StringBuilder("a");
            for (String word : S.split(" ")) {
                char c = Character.toLowerCase(word.charAt(0));
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    sentence.append(word);
                } else {
                    sentence.append(word.substring(1)).append(word.charAt(0));
                }
                sentence.append("ma").append(suffix).append(" ");
                suffix.append("a");
            }
            return sentence.deleteCharAt(sentence.length() - 1).toString();
        }
    }

    private static class S2 extends Solution824 {
        @Override
        public String toGoatLatin(String S) {
            StringBuilder sentence = new StringBuilder();
            StringBuilder suffix = new StringBuilder("a");
            StringBuilder word = new StringBuilder();
            for (char c : S.toCharArray()) {
                if (c == ' ') {
                    sentence.append(process(word)).append("ma").append(suffix).append(" ");
                    suffix.append("a");
                    word = new StringBuilder();
                } else {
                    word.append(c);
                }
            }
            return sentence.append(process(word)).append("ma").append(suffix).toString();
        }

        private StringBuilder process(StringBuilder word) {
            char head = Character.toLowerCase(word.charAt(0));
            if (head == 'a' || head == 'e' || head == 'i' || head == 'o' || head == 'u') {
                return word;
            } else {
                return word.append(word.charAt(0)).deleteCharAt(0);
            }
        }
    }
}
