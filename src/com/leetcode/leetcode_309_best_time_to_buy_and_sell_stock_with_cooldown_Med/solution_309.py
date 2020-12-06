# coding:utf-8


class Solution:
    def maxProfit(self, prices: [int]) -> int:
        if len(prices) < 2:
            return 0
        buy, sell, cool = -prices[0], 0, 0
        for price in prices:
            buy, sell, cool = \
                max(buy, cool - price), max(buy + price, sell), max(sell, cool)
        return sell

    def maxProfit_1(self, prices: [int]) -> int:
        if len(prices) < 2:
            return 0
        buy = -prices[0]
        sell = pre_sell = 0
        for price in prices:
            buy, sell, pre_sell = \
                max(pre_sell - price, buy), max(buy + price, sell), sell
        return sell

    def maxProfit_2(self, prices: [int]) -> int:
        if not prices:
            return 0
        n = len(prices)
        cool = [0] * n
        buy = [-prices[0]] * n
        sell = [0] * n
        for i, price in enumerate(prices[1:]):
            i += 1
            cool[i] = max(cool[i - 1], sell[i - 1])
            buy[i] = max(buy[i - 1], cool[i - 1] - price)
            sell[i] = buy[i - 1] + price
        return max(cool[-1], sell[-1])


if __name__ == '__main__':
    cases = [
        ([1, 2, 3, 0, 2], 3)
    ]
    s = Solution()
    for inp, ans in cases:
        res = s.maxProfit(inp)
        print(res == ans, res, ans)
