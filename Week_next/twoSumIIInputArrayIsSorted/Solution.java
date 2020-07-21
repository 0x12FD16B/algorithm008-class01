package twoSumIIInputArrayIsSorted;

/**
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author David Liu
 */
public class Solution {

    // 暴力法, 两层循环枚举所有的和
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[0];
        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};
            }
        }

        return new int[0];
    }

    // 双指针法
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int[] twoSum1(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[0];
        int n = numbers.length, p = 0, q = n - 1;

        while (p < q) {
            int sum = numbers[p] + numbers[q];
            if (sum == target) return new int[]{p + 1, q + 1};
            else if (sum < target) p++;
            else q--;
        }

        return new int[0];
    }

}
