# coding:utf-8


class Solution:
    def coinChange(self, coins: [int], amount: int) -> int:
        if not amount:
            return 0
        coins = [c for c in coins if c <= amount]
        if not coins:
            return -1
        dp = [0] + [-1] * amount
        for i in range(min(coins), amount + 1):
            candidate = [dp[i - c] for c in coins if dp[i - c] != -1]
            if candidate:
                dp[i] = min(candidate) + 1
        return dp[-1]

    def coinChange_1(self, coins: [int], amount: int) -> int:
        MAX = float('inf')
        dp = [0] + [-1] * amount
        for i in range(1, amount + 1):
            dp[i] = min([dp[i - c] if i - c >= 0 else MAX for c in coins]) + 1
        return dp[-1] if dp[-1] != MAX else -1


if __name__ == '__main__':
    cases = [
        ([1, 2, 5], 11, 3),
        ([2], 3, -1),
        ([2], 1, -1),
        ([1], 0, 0)
    ]
    s = Solution()
    for coins, amount, ans in cases:
        res = s.coinChange(coins, amount)
        print(res == ans, res, ans)
