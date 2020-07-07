package kthSmallestElementInASortedMatrix;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 * @author David Liu
 */
public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int rc = matrix.length, cc = matrix[0].length;
        int[] elements = new int[rc * cc];
        int p = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < cc; j++) {
                elements[p++] = ints[j];
            }
        }

        Arrays.sort(elements);
        return elements[k - 1];
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = l + (r - l) / 2, count = 0;
            for (int i = 0, j = n - 1; i < n && j >= 0; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += j + 1;
            }
            if (count >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // 解法三: 按照题目给出元素值升序矩阵特性, 使用 "中间值" 二分查找
    // 矩阵中最小的元素在 matrix[0][0], 最大的元素在 matrix[n - 1][n - 1]
    // 对于题目描述的矩阵来讲, 需要使用对角线元素特性
    public int kthSmallest3(int[][] matrix, int k) {
        int n = matrix.length, left = matrix[0][0], right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (checkLessThanK(matrix, mid, k)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean checkLessThanK(int[][] matrix, int mid, int k) {
        int count = 0, j = 0, i = matrix.length - 1;
        while (i >= 0 && j < matrix.length) {
            if (matrix[i][j] <= mid) {
                j++;
                count += i + 1;
            } else {
                i--;
            }
            if (count >= k) return false;
        }

        return true;
    }

}
