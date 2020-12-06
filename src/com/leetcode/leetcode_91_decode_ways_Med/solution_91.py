# coding:utf-8


class Solution:
    def numDecodings(self, s: str) -> int:
        s = s.replace('10', '&').replace('20', '&')
        if '0' in s:
            return 0
        res = 1
        p = q = 1
        for i in range(1, len(s)):
            if s[i] == '&':
                res *= q
                p = q = 1
            elif s[i - 1] != '&':
                q, p = q + p * int(10 < int(s[i - 1: i + 1]) < 27), q
        if s[-1] != '&':
            res *= q
        return res

    def numDecodings_1(self, s: str) -> int:
        n = len(s)
        dp = [1] + [0] * (n)
        for i in range(1, n + 1):
            if s[i - 1] != '0':
                dp[i] += dp[i - 1]
            if i > 1 and '09' < s[i - 2: i] < '27':
                dp[i] += dp[i - 2]
        return dp[-1]


if __name__ == '__main__':
    cases = [
        ('12', 2),
        ('226', 3),
        ('101', 1)
    ]
    for case in cases:
        res = Solution().numDecodings_1(case[0])
        print(res == case[1], res)
