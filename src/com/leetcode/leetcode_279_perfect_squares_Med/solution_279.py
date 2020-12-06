# coding:utf-8


class Solution:
    _dp = [0]

    def numSquares(self, n: int) -> int:
        dp = self._dp
        while len(dp) <= n:
            # dp.append(min(
            #    dp[-i ** 2] for i in range(1, int(len(dp) ** 0.5) + 1)) + 1)
            dp += min(dp[-i*i] for i in range(1, int(len(dp) ** 0.5 + 1))) + 1,
        # not dp[-1]
        return dp[n]


if __name__ == '__main__':
    cases = [
        (1, 1),
        (12, 3),
        (13, 2),
        (16, 1),
        (23, 4),
        (32, 2),
        (48, 3)
    ]
    s = Solution()
    for inp, ans in cases:
        res = s.numSquares(inp)
        print(res == ans, res)
