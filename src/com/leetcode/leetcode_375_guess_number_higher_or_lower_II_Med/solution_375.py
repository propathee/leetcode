# coding:utf-8


class Solution:
    def getMoneyAmount(self, n: int) -> int:
        def cost(x, p, q):
            if x == p:
                res = dp[x + 1][q]
            elif x == q:
                res = dp[p][x - 1]
            else:
                res = max(dp[p][x - 1], dp[x + 1][q])
            return res + x + 1
        dp = [[0] * n for _ in range(n)]
        for interval in range(1, n):
            for i in range(n - interval):
                j = i + interval
                dp[i][j] = min((cost(x, i, j) for x in range(i, j + 1)))
        # print(dp)
        return dp[0][-1]

    def getMoneyAmount_1(self, n: int) -> int:
        def dp(s, e):
            if s >= e:
                return 0
            if t[s][e] > 0:
                return t[s][e]
            t[s][e] = min((x + max(dp(s, x - 1), dp(x + 1, e))
                           for x in range(s, e + 1)))
            return t[s][e]

        t = [[0] * (n + 1) for _ in range(n + 1)]
        return dp(1, n)

    def getMoneyAmount_2(self, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(n + 1)]
        for j in range(2, n + 1):
            for i in range(j - 1, 0, -1):
                dp[i][j] = min((x + max(dp[i][x - 1], dp[x + 1][j])
                                for x in range(i, j)))
        return dp[1][-1]


if __name__ == '__main__':
    cases = [
        (2, 1)
    ]
    s = Solution()
    for inp, ans in cases:
        res = s.getMoneyAmount_2(inp)
        print(res == ans, res, ans)
