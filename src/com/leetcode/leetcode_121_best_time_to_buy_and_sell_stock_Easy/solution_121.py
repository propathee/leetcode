# coding:utf-8


class Solution:
    def maxProfit(self, prices: [int]) -> int:
        profit = 0

        if prices:
            cost = prices[0]

            for price in prices[1:]:
                profit = max(price - cost, profit)
                cost = min(price, cost)
        return profit


if __name__ == '__main__':
    cases = [
        ([7, 1, 5, 3, 6, 4], 5),
        ([7, 6, 4, 3, 1], 0)
    ]
    for case in cases:
        print(Solution().maxProfit(case[0]))
