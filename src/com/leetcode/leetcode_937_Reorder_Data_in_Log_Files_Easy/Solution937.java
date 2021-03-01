package com.leetcode.leetcode_937_Reorder_Data_in_Log_Files_Easy;

import java.util.Arrays;
import java.util.Comparator;

abstract class Solution937 {
    public abstract String[] reorderLogFiles(String[] logs);

    static Solution937 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution937 {
        @Override
        public String[] reorderLogFiles(String[] logs) {
            Comparator<String> comparator = (s1, s2) -> {
                int i1 = findFirstSpace(s1);
                int i2 = findFirstSpace(s2);
                String content1 = s1.substring(i1 + 1);
                String content2 = s2.substring(i2 + 1);
                if (isLetterLog(content1)) {
                    if (!isLetterLog(content2)) {
                        return 1;
                    } else {
                        int res = content2.compareTo(content1);
                        return res != 0 ? res : s2.substring(0, i2).compareTo(s1.substring(0, i1));
                    }
                } else {
                    return isLetterLog(content2) ? -1 : 1;
                }
            };

            for (int i = 0; i < logs.length; i++) {
                for (int j = logs.length - 1; j > i; j--) {
                    if (comparator.compare(logs[j - 1], logs[j]) < 0) {
                        String tmp = logs[j];
                        logs[j] = logs[j - 1];
                        logs[j - 1] = tmp;
                    }
                }
            }
            return logs;
        }

        private boolean isLetterLog(String content) {
            return !Character.isDigit(content.charAt(0));
        }

        private int findFirstSpace(String log) {
            for (int i = 0; i < log.length(); i++) {
                if (log.charAt(i) == ' ') {
                    return i;
                }
            }
            return -1;
        }
    }

    private static class S2 extends Solution937 {
        @Override
        public String[] reorderLogFiles(String[] logs) {
            Arrays.sort(logs, (s1, s2) -> {
                int i1 = findFirstSpace(s1);
                int i2 = findFirstSpace(s2);
                String content1 = s1.substring(i1 + 1);
                String content2 = s2.substring(i2 + 1);
                if (isLetterLog(content1)) {
                    if (!isLetterLog(content2)) {
                        return -1;
                    } else {
                        int res = content1.compareTo(content2);
                        return res != 0 ? res : s1.substring(0, i1).compareTo(s2.substring(0, i2));
                    }
                } else {
                    return isLetterLog(content2) ? 1 : 0;
                }
            });
            return logs;
        }

        private boolean isLetterLog(String content) {
            return content.charAt(0) > '9';
        }

        private int findFirstSpace(String log) {
            return log.indexOf(" ");
        }
    }
}
