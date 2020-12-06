# coding:utf-8


class Solution:
    def wordBreak(self, s: str, wordDict: [str]) -> bool:
        if not wordDict or not s:
            return False
        n = max([len(w) for w in wordDict])
        dp = [True] + [False] * len(s)
        for i in range(len(s)):
            for j in range(max(i - n, 0), i + 1):
                if dp[j] and (s[j: i + 1] in wordDict):
                    dp[i + 1] = True
                    break
        return dp[-1]

    def wordBreak_1(self, s: str, wordDict: [str]) -> bool:
        if not wordDict or not s:
            return False
        dp = [False] * len(s)
        for i in range(len(s)):
            for w in wordDict:
                if i - len(w) >= -1 and w == s[i - len(w) + 1: i + 1] and \
                        (dp[i - len(w)] or i - len(w) == -1):
                    dp[i] = True
        return dp[-1]


if __name__ == '__main__':
    cases = [
        ("leetcode", ["leet", "code"], True),
        ("applepenapple", ["apple", "pen"], True),
        ("catsandog", ["cats", "dog", "sand", "and", "cat"], False)
    ]
    for s, d, ans in cases:
        res = Solution().wordBreak(s, d)
        print(res == ans, res)
