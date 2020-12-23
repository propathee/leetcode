package com.leetcode.leetcode_520_Detect_Capital_Easy;

abstract class Solution520 {
    /**
     * The input will be a non-empty word consisting of uppercase and lowercase latin letters.
     */
    public abstract boolean detectCapitalUse(String word);

    static Solution520 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution520 {
        @Override
        public boolean detectCapitalUse(String word) {
            if (!Character.isUpperCase(word.charAt(0))) {
                for (int i = 1; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            } else if (word.length() > 2){
                boolean isUpper = Character.isUpperCase(word.charAt(1));
                for (int i = 2; i < word.length(); i++) {
                    if (Character.isUpperCase(word.charAt(i)) != isUpper) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private static class S2 extends Solution520 {
        @Override
        public boolean detectCapitalUse(String word) {
            int cnt = 0;
            for (char c : word.toCharArray()) {
                if ('Z' - c >= 0) {
                    cnt++;
                }
            }
            return cnt == 0 || cnt == word.length() || (cnt == 1 && 'Z' - word.charAt(0) > 0);
        }
    }

    private static class S3 extends Solution520 {
        @Override
        public boolean detectCapitalUse(String word) {
            return word.matches("[A-Z]+|[a-z]+|[A-z][a-z]+");
        }
    }

    private static class S4 extends Solution520 {
        @Override
        public boolean detectCapitalUse(String word) {
            return word.matches("[A-Z]*|[A-Z]?[a-z]+");
        }
    }

    private static class S5 extends Solution520 {
        @Override
        public boolean detectCapitalUse(String word) {
            return word.matches("[A-Z]+|.[a-z]*");
        }
    }
}
