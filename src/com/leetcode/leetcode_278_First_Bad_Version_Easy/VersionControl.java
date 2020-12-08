package com.leetcode.leetcode_278_First_Bad_Version_Easy;

class VersionControl {
    private final int firstBadVersion;

    VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}
