# coding:utf-8


class Solution:
    def maxProduct(self, nums: [int]) -> int:
        pos = neg = nums[0]
        res = nums[0]
        for n in nums[1:]:
            if n == 0:
                pos = neg = 0
                res = max(res, 0)
            elif n > 0:
                pos = max(pos, 1) * n
                neg *= n
                res = max(pos, res)
            else:
                pos, neg = neg * n, min(pos * n, n)
                res = max(pos, res)
        return res

    def maxProduct_1(self, nums: [int]) -> int:
        imax = imin = nums[0]
        res = nums[0]
        for n in nums[1:]:
            if n < 0:
                imax, imin = imin, imax
            imax = max(imax * n, n)
            imin = min(imin * n, n)
            res = max(imax, res)
        return res

    def maxProduct_1(self, nums: [int]) -> int:
        re_nums = nums[::-1]
        for i in range(1, len(nums)):
            nums[i] *= nums[i - 1] or 1
            re_nums[i] *= re_nums[i - 1] or 1
        return max(nums + re_nums)


if __name__ == '__main__':
    cases = [
        ([2, 3, -2, 4], 6),
        ([-2, 0, -1], 0),
        ([3, -1, 4], 4),
        ([-2], -2),
        ([-4, -3], 12)
    ]
    for inp, ans in cases:
        res = Solution().maxProduct(inp)
        print(res == ans, res)
