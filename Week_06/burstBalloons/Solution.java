package burstBalloons;

/**
 * https://leetcode-cn.com/problems/burst-balloons/
 *
 * @author David Liu
 */
public class Solution {

    // 使用动态规划
    // 1. 找出重复子问题(子问题相互独立): 假定 nums[-1] = nums[n] = 1, 问题可以重新定义为在一排气球 points 中, 戳破 0 和 n + 1 之间所有的气球(不包括 0 和 n + 1)
    //    使得最终只剩下气球 0 和气球 n + 1 两个气球, 最多能得到多少分
    // 2. 定义状态数组: dp[i][j] (戳破 (i, j) 区间内所有气球能够获取到最多的金币)
    // 3. 定义状态转移方程: dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[j] * points[k])
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        // 添加虚拟气球 nums[-1], nums[n]
        points[0] = points[n + 1] = 1;
        System.arraycopy(nums, 0, points, 1, n);
        // 定义 dp 状态数组, dp[i][j] 表示戳破 (i, j) 区间内所有气球能够获取到最多的金币), 那么最终的结果就在 dp[0][n + 1] 中
        int[][] dp = new int[n + 2][n + 2];
        // 自底向上构建 dp 状态数组, 因为是 (n + 2) * (n + 2) 二维数组, 只需要构建左上到右下对角线右边的部分
        for (int i = n; i >= 0; i--) {
            // 从左到右遍历
            for (int j = i + 1; j < n + 2; j++) {
                // 枚举 (i, j) 区间内仅剩下 k 的所有情况
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]);
                }
            }
        }
        return dp[0][n + 1];
    }
}
