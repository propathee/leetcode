# coding:utf-8


class Solution:
    def rob(self, nums: [int]) -> int:
        p = q = 0

        for n in nums:
            p, q = q, max(p + n, q)
        return q


if __name__ == '__main__':
    cases = [
        ([1, 2, 3, 1], 4),
        ([2, 7, 9, 3, 1], 12)
    ]
    for case in cases:
        print(Solution().rob(case[0]))
