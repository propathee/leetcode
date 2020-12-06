# coding:utf-8


class Solution:
    def lengthOfLIS_dp(self, nums: [int]) -> int:
        if len(nums) < 2:
            return len(nums)
        dp = [1] * len(nums)
        for i in range(1, len(nums)):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[j] + 1, dp[i])
        return max(dp)

    def lengthOfLIS(self, nums: [int]) -> int:
        tails = [0] * len(nums)
        size = 0
        for x in nums:
            i, j = 0, size
            while i != j:
                mid = (i + j) // 2
                if x > tails[mid]:
                    i = mid + 1
                else:
                    j = mid
            tails[i] = x
            size = max(i + 1, size)
        return size


if __name__ == '__main__':
    cases = [
        ([10, 9, 2, 5, 3, 7, 101, 18], 4)
    ]
    s = Solution()
    for inp, ans in cases:
        res = s.lengthOfLIS(inp)
        print(res == ans, res)
