package searchA2dMatrix;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 *
 * @author David Liu
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        // 先找 target 在哪一行
        int row = -1;
        for (int i = 0; i < m; i++)
            if (matrix[i][0] <= target && matrix[i][n - 1] >= target) row = i;
        if (row == -1) return false;
        // 再在目标行二分查找
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return false;
    }
}
