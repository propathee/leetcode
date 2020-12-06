# coding:utf-8


class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        res = nums[0] - 1
        pre = 0

        for n in nums:
            pre = pre + n if pre > 0 else n
            res = max(res, pre)
        return res

    def maxSubArray_1(self, nums):
        cur_sum = max_sum = nums[0]
        for n in nums[1:]:
            cur_sum = max(n, n + cur_sum)
            max_sum = max(cur_sum, max_sum)
        return max_sum


if __name__ == '__main__':
    test_cases = [
        ([-2, 1, -3, 4, -1, 2, 1, -5, 4], 6)
    ]
    for case in test_cases:
        print(Solution().maxSubArray_1(case[0]))
