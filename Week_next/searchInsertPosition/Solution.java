package searchInsertPosition;

/**
 * https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author David Liu
 */
public class Solution {

    // 暴力法
    // 时间复杂度: O(N), N 为 nums 长度
    // 空间复杂度: O(1)
    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (target <= nums[i]) return i;
        }
        return n;
    }

    // 二分查找第一个大于等于 target 的元素的下标
    // 时间复杂度: O(log N), N 为 nums 长度
    // 空间复杂度: O(1)
    public int searchInsert(int[] nums, int target) {
        int n = nums.length, lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >> 1);
            if (nums[mid] >= target) {
                if ((mid == 0) || nums[mid - 1] < target) return mid;
                else hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return n;
    }
}
