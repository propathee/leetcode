package com.leetcode.leetcode_278_First_Bad_Version_Easy;

public class Solution278 extends VersionControl {
    public Solution278(int firstBadVersion) {
        super(firstBadVersion);
    }

    public int firstBadVersion_wrong(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = (l + r) / 2; // dead loop when (l+r) overflows
            if (isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return isBadVersion(l) ? l : l + 1;
    }

    public int firstBadVersion_1(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return isBadVersion(l) ? l : l + 1;
    }

    public int firstBadVersion_2(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (isBadVersion(m)) {
                r = m; // r should always be bad
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
