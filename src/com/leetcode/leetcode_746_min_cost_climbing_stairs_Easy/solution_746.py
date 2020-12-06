# coding:utf-8


# cost will have a length in the range [2, 1000].
# Every cost[i] will be an integer in the range [0, 999].
class Solution:
    def minCostClimbingStairs(self, cost: [int]) -> int:
        p = q = 0
        cost += [0]
        for i in range(2, len(cost)):
            q, p = min(p + cost[i - 2], q + cost[i - 1]), q
        return q

    def minCostClimbingStairs_1(self, cost: [int]) -> int:
        p = q = 0
        for n in reversed(cost):
            p, q = n + min(p, q), p
        return min(p, q)


if __name__ == '__main__':
    cases = [
        ([10, 15, 20], 15),
        ([1, 100, 1, 1, 1, 100, 1, 1, 100, 1], 6)
    ]
    for case in cases:
        res = Solution().minCostClimbingStairs_1(case[0])
        print(res == case[1], res)
