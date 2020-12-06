# coding:utf-8


class Solution:
    def minimumTotal(self, triangle: [[int]]) -> int:
        if not triangle:
            return 0
        n = len(triangle)
        for i in range(1, n):
            triangle[i][0] += triangle[i - 1][0]
            triangle[i][-1] += triangle[i - 1][-1]
            for j in range(1, i):
                triangle[i][j] += min(
                    triangle[i - 1][j - 1], triangle[i - 1][j])
        return min(triangle[-1])


if __name__ == '__main__':
    cases = [
        ([[2],
          [3, 4],
          [6, 5, 7],
          [4, 1, 8, 3]], 11)
    ]
    for inp, ans in cases:
        res = Solution().minimumTotal(inp)
        print(res == ans, res)
