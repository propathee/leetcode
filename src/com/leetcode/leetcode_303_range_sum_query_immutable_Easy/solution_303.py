# coding:utf-8


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)
class NumArray:

    def __init__(self, nums: [int]):
        self.sum = [0]
        for n in nums:
            self.sum.append(self.sum[-1] + n)

    def sumRange(self, i: int, j: int) -> int:
        return self.sum[j + 1] - self.sum[i]


if __name__ == '__main__':
    cases = [
        ([-2, 0, 3, -5, 2, -1],
         [(0, 2, 1), (2, 5, -1), (0, 5, -3)])
    ]
    for case in cases:
        obj = NumArray(case[0])
        for i, j, res in case[1]:
            print(obj.sumRange(i, j) == res)
