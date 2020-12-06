# coding:utf-8


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        res = 1
        for i in range(n, m + n - 1):
            res *= i
        for i in range(1, m):
            res //= i
        return res

    def uniquePaths_1(self, m: int, n: int) -> int:
        dp = [[1] * n for _ in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]

    def uniquePaths_2(self, m: int, n: int) -> int:
        dp = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                dp[j] += dp[j - 1]
        return dp[-1]


if __name__ == '__main__':
    cases = [
        ((3, 2), 3),
        ((7, 3), 28)
    ]
    for case in cases:
        res = Solution().uniquePaths_2(case[0][0], case[0][1])
        print(res == case[1], res)
