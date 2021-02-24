package com.leetcode.leetcode_929_Unique_Email_Addresses_Easy;

import java.util.HashSet;
import java.util.Set;

abstract class Solution929 {
    public abstract int numUniqueEmails(String[] emails);

    static Solution929 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution929 {
        @Override
        public int numUniqueEmails(String[] emails) {
            Set<String> set = new HashSet<>();
            for (String email : emails) {
                StringBuilder sb = new StringBuilder();
                boolean hasPlus = false;
                for (int i = 0; i < email.length(); i++) {
                    if (email.charAt(i) == '@') {
                        sb.append(email.substring(i));
                        break;
                    } else if (!hasPlus) {
                        if (email.charAt(i) == '+') {
                            hasPlus = true;
                        } else if (email.charAt(i) != '.') {
                            sb.append(email.charAt(i));
                        }
                    }
                }
                set.add(sb.toString());
            }
            return set.size();
        }
    }

    private static class S2 extends Solution929 {
        @Override
        public int numUniqueEmails(String[] emails) {
            Set<String> set = new HashSet<>();
            for (String email : emails) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < email.length(); i++) {
                    if (email.charAt(i) == '+' || email.charAt(i) == '@') {
                        while (email.charAt(i) != '@') {
                            i++;
                        }
                        sb.append(email.substring(i));
                        break;
                    } else if (email.charAt(i) != '.') {
                        sb.append(email.charAt(i));
                    }
                }
                set.add(sb.toString());
            }
            return set.size();
        }
    }
}
