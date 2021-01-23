package com.leetcode.leetcode_811_Subdomain_Visit_Count_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Solution811 {
    public abstract List<String> subdomainVisits(String[] cpdomains);

    static Solution811 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution811 {
        @Override
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> visitsMap = new HashMap<>();
            for (String domain : cpdomains) {
                String[] items = domain.split(" ");
                int cnt = Integer.parseInt(items[0]);
                StringBuilder sb = new StringBuilder();
                String[] subDomains = items[1].split("\\.");
                for (int i = subDomains.length - 1; i >= 0; i--) {
                    if (sb.length() != 0) {
                        sb.insert(0, ".");
                    }
                    sb.insert(0, subDomains[i]);
                    String key = sb.toString();
                    visitsMap.put(key, visitsMap.getOrDefault(key, 0) + cnt);
                }
            }
            List<String> res = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : visitsMap.entrySet()) {
                res.add(entry.getValue() + " " + entry.getKey());
            }
            return res;
        }
    }

    private static class S2 extends Solution811 {
        @Override
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> visitsMap = new HashMap<>();
            for (String cp : cpdomains) {
                int idx = cp.indexOf(" ");
                int cnt = Integer.parseInt(cp.substring(0, idx));
                String domain = cp.substring(idx + 1);
                for (int i = 0; i < domain.length(); i++) {
                    if (domain.charAt(i) == '.') {
                        String subDomain = domain.substring(i + 1);
                        visitsMap.put(subDomain, visitsMap.getOrDefault(subDomain, 0) + cnt);
                    }
                }
                visitsMap.put(domain, visitsMap.getOrDefault(domain, 0) + cnt);
            }
            List<String> res = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : visitsMap.entrySet()) {
                res.add(entry.getValue() + " " + entry.getKey());
            }
            return res;
        }
    }

    private static class S3 extends Solution811 {
        @Override
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> visitsMap = new HashMap<>();
            for (String cp : cpdomains) {
                int idx = cp.indexOf(" ");
                int cnt = Integer.parseInt(cp.substring(0, idx));
                String domain = cp.substring(idx + 1);
                visitsMap.put(domain, visitsMap.getOrDefault(domain, 0) + cnt);
                idx = domain.indexOf(".");
                while (idx >= 0) {
                    String subDomain = domain.substring(idx + 1);
                    visitsMap.put(subDomain, visitsMap.getOrDefault(subDomain, 0) + cnt);
                    idx = domain.indexOf(".", idx + 1);
                }
            }
            List<String> res = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : visitsMap.entrySet()) {
                res.add(entry.getValue() + " " + entry.getKey());
            }
            return res;
        }
    }

    private static class S4 extends Solution811 {
        @Override
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> visitsMap = new HashMap<>();
            for (String cp : cpdomains) {
                int idx = cp.indexOf(" ");
                int cnt = Integer.parseInt(cp.substring(0, idx));
                String domain = cp.substring(idx + 1);
                visitsMap.put(domain, visitsMap.getOrDefault(domain, 0) + cnt);
                StringBuilder sb = new StringBuilder(domain);
                while (true) {
                    int i = sb.indexOf(".");
                    if (i < 0) {
                        break;
                    } else {
                        sb.delete(0, i + 1);
                        String key = sb.toString();
                        visitsMap.put(key, visitsMap.getOrDefault(key, 0) + cnt);
                    }
                }
            }
            List<String> res = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : visitsMap.entrySet()) {
                res.add(entry.getValue() + " " + entry.getKey());
            }
            return res;
        }
    }
}
