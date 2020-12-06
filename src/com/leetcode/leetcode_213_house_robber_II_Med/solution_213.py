# coding:utf-8


class Solution:
    def rob(self, nums: [int]) -> int:
        if len(nums) <= 3:
            return max([0] + nums)
        p1 = nums[0]
        p2 = 0
        q1 = nums[0]
        q2 = nums[1]
        for n in nums[2: -1]:
            q1, p1 = max(p1 + n, q1), q1
            q2, p2 = max(p2 + n, q2), q2
        q2 = max(p2 + nums[-1], q2)
        return max(q1, q2)

    def rob_1(self, nums: [int]) -> int:
        def helper(l, r):
            include = exclude = 0
            for n in nums[l: r + 1]:
                include, exclude = exclude + n, max(include, exclude)
            return max(include, exclude)
        if len(nums) <= 3:
            return max([0] + nums)
        return max(helper(0, len(nums) - 2), helper(1, len(nums) - 1))


if __name__ == '__main__':
    cases = [
        ([2, 3, 2], 3),
        ([1, 2, 3, 1], 4),
        ([1, 7, 9, 2], 10)
    ]
    for inp, ans in cases:
        res = Solution().rob(inp)
        print(res == ans, res)
