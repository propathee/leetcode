package com.leetcode.leetcode_71_Simplify_Path_Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

abstract class Solution71 {
    public abstract String simplifyPath(String path);

    static Solution71 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution71 {
        @Override
        public String simplifyPath(String path) {
            String[] dirs = path.split("/");
            List<String> newDirs = new ArrayList<>();
            for (String dir : dirs) {
                if ("".equals(dir) || ".".equals(dir)) {
                    continue;
                } else if ("..".equals(dir)) {
                    if (!newDirs.isEmpty()) {
                        newDirs.remove(newDirs.size() - 1);
                    }
                } else {
                    newDirs.add(dir);
                }
            }
            return "/" + String.join("/", newDirs);
        }
    }

    private static class S2 extends Solution71 {
        @Override
        public String simplifyPath(String path) {
            String[] dirs = path.split("/");
            Stack<String> stack = new Stack<>();
            for (String dir : dirs) {
                if ("".equals(dir) || ".".equals(dir)) {
                    continue;
                } else if ("..".equals(dir)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(dir);
                }
            }
            return "/" + String.join("/", stack);
        }
    }

    private static class S3 extends Solution71 {
        @Override
        public String simplifyPath(String path) {
            StringBuilder dirBuilder = new StringBuilder();
            Stack<String> dirs = new Stack<>();
            for (int i = 0; i < path.length(); i++) {
                char c = path.charAt(i);
                if (c != '/' && i < path.length() - 1) {
                    dirBuilder.append(c);
                } else {
                    if (c != '/') {
                        dirBuilder.append(c);
                    }
                    String dir = dirBuilder.toString();
                    dirBuilder = new StringBuilder();
                    if ("".equals(dir) || ".".equals(dir)) {
                        continue;
                    } else if ("..".equals(dir)) {
                        if (!dirs.isEmpty()) {
                            dirs.pop();
                        }
                    } else {
                        dirs.push(dir);
                    }
                }
            }
            StringBuilder sb = new StringBuilder("");
            for (String dir : dirs) {
                sb.append("/").append(dir);
            }
            return dirs.isEmpty() ? "/" : sb.toString();
        }
    }
}
