# coding:utf-8


class Solution:
    def divisorGame(self, N: int) -> bool:
        dp = [False] * (N + 1)
        for i in range(N + 1):
            for j in range(1, i // 2 + 1):
                if i % j == 0 and not dp[i - j]:
                    dp[i] = True
                    break
        return dp[-1]


if __name__ == '__main__':
    cases = [(i, i % 2 == 0) for i in range(1, 10)]
    for case in cases:
        res = Solution().divisorGame(case[0])
        print(res == case[1], res)
