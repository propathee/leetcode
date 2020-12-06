# coding:utf-8


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: [[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[1] * n for _ in range(m)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] -= obstacleGrid[i][j]
        for i in range(0, m):
            if obstacleGrid[i][0] == 1:
                for j in range(i, m):
                    dp[j][0] = 0
                break
        for i in range(0, n):
            if obstacleGrid[0][i] == 1:
                for j in range(i, n):
                    dp[0][j] = 0
                break
        for i in range(1, m):
            for j in range(1, n):
                if dp[i][j]:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]

    def uniquePathsWithObstacles_1(self, obstacleGrid: [[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [0] * n
        dp[0] = 1 - obstacleGrid[0][0]
        for i in range(1, n):
            dp[i] = dp[i - 1] * (1 - obstacleGrid[0][i])
        for i in range(1, m):
            dp[0] *= (1 - obstacleGrid[i][0])
            for j in range(1, n):
                dp[j] = (dp[j - 1] + dp[j]) * (1 - obstacleGrid[i][j])
        return dp[-1]

    def uniquePathsWithObstacles_2(self, obstacleGrid: [[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        obstacleGrid[0][0] = 1 - obstacleGrid[0][0]
        for i in range(1, m):
            obstacleGrid[i][0] = obstacleGrid[i - 1][0] * \
                (1 - obstacleGrid[i][0])
        for j in range(1, n):
            obstacleGrid[0][j] = obstacleGrid[0][j - 1] * \
                (1 - obstacleGrid[0][j])
        for i in range(1, m):
            for j in range(1, n):
                obstacleGrid[i][j] = \
                    (obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]) * \
                    (1 - obstacleGrid[i][j])
        return obstacleGrid[-1][-1]


if __name__ == '__main__':
    cases = [
        ([[0, 0, 0],
          [0, 1, 0],
          [0, 0, 0]], 2)
    ]
    for case in cases:
        res = Solution().uniquePathsWithObstacles_2(case[0])
        print(res == case[1], res)
