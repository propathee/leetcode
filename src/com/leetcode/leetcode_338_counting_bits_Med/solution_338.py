# coding:utf-8


class Solution:
    def countBits(self, num: int) -> [int]:
        if num < 2:
            return [0, 1][:num + 1]
        dp = [0] + [1] * num
        base = 1
        for i in range(2, num + 1):
            if base * 2 <= i:
                base *= 2
            dp[i] = dp[i - base] + 1
        return dp


if __name__ == '__main__':
    cases = [
        (2, [0, 1, 1]),
        (5, [0, 1, 1, 2, 1, 2])
    ]
    s = Solution()
    for inp, ans in cases:
        res = s.countBits(inp)
        print(res == ans, res, ans)
