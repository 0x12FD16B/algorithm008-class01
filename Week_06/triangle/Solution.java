package triangle;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 *
 * @author David Liu
 */
public class Solution {

    // 使用 dp (自顶向下)
    // 时间复杂度 O(M * N)
    //  1. 分治(问题重复性)
    //  2. 状态数组: F[i] 记录第 i 层的最小路径和
    //  3. 状态转移方程 F[i] = min(F[i], F[i + 1]) + row
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> rows = triangle.get(i);
            for (int j = 0; i < rows.size(); j++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + rows.get(j);
        }
        return dp[0];
    }

    // 使用递归
    // 时间复杂度: O(2^k), k = triangle 列表的长度
    private int minimumTotalRecursion(List<List<Integer>> triangle, int row, int col) {
        // terminator
        if (row == triangle.size() - 1) return triangle.get(row).get(col);
        // process current logic
        int val = triangle.get(row).get(col);
        // drill down
        int colBound = Math.min(col + 1, triangle.get(row + 1).size() - 1);
        int res = Integer.MAX_VALUE;
        for (int i = col; i <= colBound; i++)
            res = Math.min(res, minimumTotalRecursion(triangle, row + 1, i));
        return res + val;
    }
}
