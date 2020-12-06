# coding:utf-8


class Solution:
    def longestPalindrome(self, s: str) -> str:
        def helper(s, l, r):
            while l >= 0 and r < len(s) and s[l] == s[r]:
                l -= 1
                r += 1
            return s[l + 1: r]

        res = ''
        for i in range(len(s)):
            tmp = helper(s, i, i)
            if len(tmp) > len(res):
                res = tmp
            tmp = helper(s, i, i + 1)
            if len(tmp) > len(res):
                res = tmp
        return res

    def longestPalindrome_1(self, s: str) -> str:
        if not s:
            return ''
        res = s[0]
        n = len(s)
        dp = [[False] * n for _ in range(n)]

        for i in range(n - 1):
            dp[i][i] = True
            if s[i] == s[i + 1]:
                dp[i][i + 1] = True
                res = s[i: i + 2]
        for r in range(n):
            for l in range(r - 1):
                if s[l] == s[r] and dp[l + 1][r - 1]:
                    dp[l][r] = True
                    if r - l + 1 > len(res):
                        res = s[l: r + 1]
        return res


if __name__ == '__main__':
    cases = [
        ('babad', 3),
        ('cbbd', 2),
        ('a', 1),
        ('', 0)
    ]
    for case in cases:
        res = Solution().longestPalindrome(case[0])
        print(res)
