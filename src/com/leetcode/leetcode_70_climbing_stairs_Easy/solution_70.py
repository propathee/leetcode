# coding:utf-8


class Solution:
    def climbStairs(self, n: int) -> int:
        if n < 3:
            return n

        p, q = 1, 2

        for _ in range(n - 2):
            p, q = q, p + q
        return q


if __name__ == '__main__':
    cases = [
        (2, 2),
        (3, 3)
    ]
    for case in cases:
        print(Solution().climbStairs(case[0]))
