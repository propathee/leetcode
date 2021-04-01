# coding:utf-8


class Solution:
    def numTrees(self, n: int) -> int:
        if not n:
            return 0
        dp = [1] + [0] * (n)
        for i in range(1, n + 1):
            for j in range(1, i + 1):
                dp[i] += dp[j - 1] * dp[i - j]
        return dp[-1]


if __name__ == '__main__':
    cases = [
        (3, 5)
    ]
    for inp, ans in cases:
        res = Solution().numTrees(inp)
        print(res == ans, res)
