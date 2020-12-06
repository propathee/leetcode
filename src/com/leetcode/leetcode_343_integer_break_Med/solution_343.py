# coding:utf-8


class Solution:
    def integerBreak(self, n: int) -> int:
        if n < 4:
            return [0, 0, 1, 2][n]
        dp = [1, 1, 2] + [0] * (n - 2)
        for i in range(3, n + 1):
            dp[i] = max(2 * dp[i - 2], 3 * dp[i - 3])
        return dp[-1]

    def integerBreak_1(self, n: int) -> int:
        if n < 4:
            return [0, 0, 1, 2][n]
        res = 1
        while n > 4:
            res *= 3
            n -= 3
        res *= n
        return res


if __name__ == '__main__':
    cases = [
        (2, 1),
        (10, 36)
    ]
    s = Solution()
    for inp, ans in cases:
        res = s.integerBreak_1(inp)
        print(res == ans, res, ans)
