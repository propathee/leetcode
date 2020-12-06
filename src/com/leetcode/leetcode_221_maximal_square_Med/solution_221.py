# coding:utf-8


class Solution:
    def maximalSquare_deprecated(self, matrix: [[str]]) -> int:
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        res = int(matrix[0][0])
        for i in range(m):
            for j in range(n):
                matrix[i][j] = int(matrix[i][j])
        matrix[0][0] = (matrix[0][0],) * 3
        for i in range(1, m):
            matrix[i][0] = (
                matrix[i][0],
                matrix[i][0],
                (matrix[i - 1][0][2] + 1) * matrix[i][0])
            res = max(matrix[i][0][1], res)
        for j in range(1, n):
            matrix[0][j] = (
                (matrix[0][j - 1][0] + 1) * matrix[0][j],
                matrix[0][j],
                matrix[0][j])
            res = max(matrix[0][j][1], res)
        for i in range(1, m):
            for j in range(1, n):
                if matrix[i][j]:
                    s = min(
                        matrix[i][j - 1][0],
                        matrix[i - 1][j][2],
                        matrix[i - 1][j - 1][1]) + 1
                    matrix[i][j] = (
                        matrix[i][j - 1][0] + 1, s, matrix[i - 1][j][2] + 1)
                    res = max(s, res)
                else:
                    matrix[i][j] = (0, 0, 0)
        # print(matrix)
        return res * res

    def maximalSquare(self, matrix: [[str]]) -> int:
        if not matrix:
            return 0
        res = 0
        m, n = len(matrix), len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 1:
                    if i == 0 or j == 0:
                        matrix[i][j] = 1
                    else:
                        matrix[i][j] = min(
                            matrix[i - 1][j],
                            matrix[i][j - 1],
                            matrix[i - 1][j - 1]) + 1
                    res = max(matrix[i][j], res)
                else:
                    matrix[i][j] = 0
        return res * res


if __name__ == '__main__':
    cases = [
        ([[1, 0, 1, 0, 0],
          [1, 0, 1, 1, 1],
          [1, 1, 1, 1, 1],
          [1, 0, 0, 1, 0]], 4),
        ([[1, 1],
          [1, 1]], 4)
    ]
    for inp, ans in cases:
        res = Solution().maximalSquare(inp)
        print(res == ans, res)
