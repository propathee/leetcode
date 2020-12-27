package com.leetcode.leetcode_551_Student_Attendance_Record_I_Easy;

abstract class Solution551 {
    public abstract boolean checkRecord(String s);

    static Solution551 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution551 {
        @Override
        public boolean checkRecord(String s) {
            int absent = 0;
            int late = 0;
            for (char c : s.toCharArray()) {
                if (c == 'L') {
                    late++;
                } else if (c == 'A') {
                    absent++;
                    late = 0;
                } else {
                    late = 0;
                }
                if (absent > 1 || late > 2) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S2 extends Solution551 {
        @Override
        public boolean checkRecord(String s) {
            int absent = 0;
            int late = 0;
            for (char c : s.toCharArray()) {
                if (c == 'A') {
                    absent++;
                }
                if (c == 'L') {
                    late++;
                } else {
                    late = 0;
                }
                if (absent > 1 || late > 2) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S3 extends Solution551 {
        @Override
        public boolean checkRecord(String s) {
            return !s.contains("LLL") && s.indexOf("A") == s.lastIndexOf("A");
        }
    }

    private static class S4 extends Solution551 {
        @Override
        public boolean checkRecord(String s) {
            return !s.matches(".*LLL.*|.*A.*A.*");
        }
    }

    private static class S5 extends Solution551 {
        @Override
        public boolean checkRecord(String s) {
            int absent = 0;
            int late = 0;
            char preChar = 0;
            for (char c : s.toCharArray()) {
                if (c == 'A') {
                    absent++;
                }
                if (c == 'L') {
                    if (preChar == 'L') {
                        late++;
                    } else {
                        late = 1;
                    }
                }
                preChar = c;
                if (absent > 1 || late > 2) {
                    return false;
                }
            }
            return true;
        }
    }
}
