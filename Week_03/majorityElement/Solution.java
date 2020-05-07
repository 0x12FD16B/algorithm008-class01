package majorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element/
 *
 * @author David Liu
 */
public class Solution {
    // 解法一: 排序
    // 时间复杂度: O(NlogN)
    // 空间复杂度: O(1)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 解法二: 哈希表
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int n : nums) {
            int count = numCount.getOrDefault(n, 0);
            if (count + 1 > nums.length / 2) return n;
            numCount.put(n, count + 1);
        }
        return -1;
    }

    // 解法三: 摩尔投票法
    // 时间复杂度: O(N)
    // 空间复杂度: O(1)
    public int majorityElement3(int[] nums) {
        int count = 0, candidate = -1;
        for (int n : nums) {
            if (count == 0) candidate = n;
            count += (n == candidate ? 1 : -1);
        }
        return candidate;
    }

    // 解法四: 分治法
    // 时间复杂度: O(NlogN)
    // 空间复杂度: O(logN)
    public int majorityElement4(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int lo, int hi) {
        // terminator
        if (lo == hi) return nums[lo];

        // prepare data
        int mid = ((hi - lo) >> 2) + lo;
        // conquer sub problems
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid + 1, hi);

        // process and generate final result
        if (left == right) return left;

        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;

    }

    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }

}
