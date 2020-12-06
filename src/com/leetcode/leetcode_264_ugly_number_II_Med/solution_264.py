# coding:utf-8


class Solution:
    def nthUglyNumber(self, n: int) -> int:
        i2 = i3 = i5 = 0
        ugly = [1]
        for _ in range(1, n):
            ugly.append(min(ugly[i2] * 2, ugly[i3] * 3, ugly[i5] * 5))
            if ugly[-1] == ugly[i2] * 2:
                i2 += 1
            if ugly[-1] == ugly[i3] * 3:
                i3 += 1
            if ugly[-1] == ugly[i5] * 5:
                i5 += 1
        return ugly[-1]

    def nthUglyNumber_1(self, n: int) -> int:
        ugly = [1]
        i2 = i3 = i5 = 0
        for _ in range(1, n):
            if ugly[i2] * 2 <= ugly[-1]:
                i2 += 1
            if ugly[i3] * 3 <= ugly[-1]:
                i3 += 1
            if ugly[i5] * 5 <= ugly[-1]:
                i5 += 1
            ugly.append(min(ugly[i2] * 2, ugly[i3] * 3, ugly[i5] * 5))
        return ugly[-1]


if __name__ == '__main__':
    cases = [
        (10, 12)
    ]
    for inp, ans in cases:
        res = Solution().nthUglyNumber(inp)
        print(res == ans, res)
