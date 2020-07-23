package minimumPathSum;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 *
 * @author David Liu
 */
public class Solution {

    private int minPathSum = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        dfs(grid, 0, 0, grid.length, grid[0].length, 0);
        return minPathSum;
    }

    private void dfs(int[][] grid, int r, int c, int row, int col, int sum) {
        sum += grid[r][c];
        if (r == row - 1 && c == col - 1) {
            minPathSum = Math.min(minPathSum, sum);
            return;
        }
        if (c + 1 < col) dfs(grid, r, c + 1, row, col, sum);
        if (r + 1 < row) dfs(grid, r + 1, c, row, col, sum);
    }

    public int minPathSum_bfs(int[][] grid) {
        int minPathSum = Integer.MAX_VALUE, row = grid.length, col = grid[0].length;
        Queue<Pair<Integer, Integer>> pathQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        pathQueue.offer(new Pair<>(0, 0));
        sumQueue.offer(grid[0][0]);

        while (!pathQueue.isEmpty()) {
            Pair<Integer, Integer> pos = pathQueue.poll();
            Integer pathSum = sumQueue.poll();
            int x = pos.getKey(), y = pos.getValue();
            if (x == col - 1 && y == row - 1) {
                minPathSum = Math.min(pathSum, minPathSum);
            }
            if (x + 1 < col) {
                pathQueue.offer(new Pair<>(x + 1, y));
                sumQueue.offer(pathSum + grid[x + 1][y]);
            }
            if (y + 1 < row) {
                pathQueue.offer(new Pair<>(x, y + 1));
                sumQueue.offer(pathSum + grid[x][y + 1]);
            }
        }

        return minPathSum;
    }

    public int minPathSum_dp(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        // 初始化 dp 方程
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }

    public int minPathSum_dp2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];

        for (int c = 1; c < grid[0].length; c++) dp[c] = dp[c - 1] + grid[0][c];

        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
            }
        }

        return dp[n - 1];
    }
}

// 解法一: 递归
// 时间复杂度: O(M * N)
// 空间复杂度: O(M * N)

// 解法二: 广度优先遍历, 从起点开始, 按照规则广度优先遍历构造路径, 计算所有路径中路径和最小的
// 时间复杂度: O(M * N)
// 空间复杂度: O(M * N)

// 解法三: 动态规划
// dp[i][j] 表示走到 (i, j) 位置的最短路径和
// dp 方程: dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
// 时间复杂度: O(M * N)
// 空间复杂度: O(M * N)

// 解法四: 动态规划(降维)
// dp[i] 表示走到每一行第 i 列的最短路径
// 时间复杂度: O(M * N)
// 空间复杂度: O(N)
