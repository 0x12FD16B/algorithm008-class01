package maximumLengthOfRepeatedSubarray;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray
 *
 * @author David Liu
 */
public class Solution {
    // bruce force
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = 0;
                while (i + k < m && j + k < n && A[i + k] == B[j + k]) {
                    k++;
                }
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }

    // 动态规划, dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀，
    // 那么答案即为所有 dp[i][j] 中的最大值。如果 A[i] == B[j]，那么 dp[i][j] = dp[i + 1][j + 1] + 1，否则 dp[i][j] = 0。
    public int findLength1(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    // 滑动窗口, 依次枚举 A, B 元素在相同元素下标对齐后的子数组元素数量
    public int findLength2(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxLen = maxLength(A, B, i, 0, len);
            ans = Math.max(maxLen, ans);
        }

        for (int j = 0; j < n; j++) {
            int len = Math.min(m, n - j);
            int maxLen = maxLength(A, B, 0, j, len);
            ans = Math.max(maxLen, ans);
        }

        return ans;
    }

    private int maxLength(int[] A, int[] B, int offsetA, int offsetB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[i + offsetA] == B[i + offsetB]) k++;
            else k = 0;
            ret = Math.max(k, ret);
        }
        return ret;
    }
}
