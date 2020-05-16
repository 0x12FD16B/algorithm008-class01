package findRotatedSortedArrayRotatePoint;

/**
 * 寻找旋转有序数组的旋转点
 *
 * @author David Liu
 */
public class Solution {

    public int findRotatedPoint(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        if (nums[hi] > nums[lo]) return -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) return mid + 1;
            if (nums[mid - 1] > nums[mid]) return mid;
            if (nums[mid] > nums[0]) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

}
