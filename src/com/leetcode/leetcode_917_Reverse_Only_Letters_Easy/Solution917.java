package com.leetcode.leetcode_917_Reverse_Only_Letters_Easy;

abstract class Solution917 {
    public abstract String reverseOnlyLetters(String S);

    static Solution917 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution917 {
        @Override
        public String reverseOnlyLetters(String S) {
            StringBuilder sb = new StringBuilder();
            int p = 0, q = S.length() - 1;
            for (; p < S.length(); p++) {
                if (!isLetter(S.charAt(p))) {
                    sb.append(S.charAt(p));
                } else {
                    while (!isLetter(S.charAt(q))) {
                        q--;
                    }
                    sb.append(S.charAt(q--));
                }
            }
            return sb.toString();
        }

        private boolean isLetter(char c) {
            return Character.isLetter(c);
        }
    }

    private static class S2 extends Solution917 {
        @Override
        public String reverseOnlyLetters(String S) {
            StringBuilder sb = new StringBuilder(S);
            for (int i = 0, j = S.length() - 1; i < j;) {
                if (!isLetter(sb.charAt(i))) {
                    i++;
                } else if (!isLetter(sb.charAt(j))) {
                    j--;
                } else {
                    sb.setCharAt(i, S.charAt(j));
                    sb.setCharAt(j--, S.charAt(i++));
                }
            }
            return sb.toString();
        }

        private boolean isLetter(char c) {
            return Character.isLetter(c);
        }
    }

    private static class S3 extends Solution917 {
        @Override
        public String reverseOnlyLetters(String S) {
            char[] chars = S.toCharArray();
            for (int i = 0, j = S.length() - 1; i < j;) {
                if (!isLetter(chars[i])) {
                    i++;
                } else if (!isLetter(chars[j])) {
                    j--;
                } else {
                    char tmp = chars[i];
                    chars[i++] = chars[j];
                    chars[j--] = tmp;
                }
            }
            return new String(chars);
        }

        private boolean isLetter(char c) {
            return Character.isLetter(c);
        }
    }
}
