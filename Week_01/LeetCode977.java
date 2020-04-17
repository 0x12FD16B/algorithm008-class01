import java.util.Arrays;

/**
 * squares-of-a-sorted-array
 *
 * @author David Liu
 * @link https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 */
public class LeetCode977 {

    // 解法1. 将入参的每个数计算平方, 然后排序后返回
    // 时间复杂度: O(nlogn)
    // 时间复杂度: O(1)
    public int[] sortedSquares1(int[] A) {
        int length = A.length;
        for (int i = 0; i < length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    // 解法2. 新开一个数组, 在入参中使用左右两个指针向中间滑动计算元素的平方
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int[] sortedSquares2(int[] A) {
        int len = A.length, l = 0, r = len - 1;
        int[] res = new int[len];
        int writeIndex = len - 1;
        while (l <= r) {
            if (A[l] + A[r] > 0) {
                res[writeIndex--] = A[r] * A[r];
                r--;
            } else {
                res[writeIndex--] = A[l] * A[l];
                l++;
            }
        }
        return res;
    }
}
