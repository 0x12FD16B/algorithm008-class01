package removeDuplicatesFromSortedArray;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 *
 * @author David Liu
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cur = nums[0], p = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != cur) {
                cur = nums[i];
                nums[p++] = nums[i];
            }
        }
        return p;
    }
}
