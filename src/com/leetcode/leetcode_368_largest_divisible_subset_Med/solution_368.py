# coding:utf-8


class Solution:
    def largestDivisibleSubset(self, nums: [int]) -> [int]:
        S = {-1: set()}
        for x in sorted(nums):
            S[x] = max((S[d] for d in S if x % d == 0), key=len) | {x}
        return list(max(S.values(), key=len))

    def largestDivisibleSubset_1(self, nums: [int]) -> [int]:
        dp = [[]]
        for x in sorted(nums):
            dp.append(
                max([s for s in dp if not s or x % s[-1] == 0], key=len) + [x])
        return max(dp, key=len)


if __name__ == '__main__':
    cases = [
        ([1, 2, 4, 8], [1, 2, 4, 8]),
        ([1, 2, 4, 8, 50, 150, 450], [1, 2, 50, 150, 450]),
        ([1, 2, 4, 8, 50, 200], [1, 2, 4, 8, 200])
    ]
    s = Solution()
    for inp, ans in cases:
        res = s.largestDivisibleSubset(inp)
        print(sorted(res) == ans, ans, res)
