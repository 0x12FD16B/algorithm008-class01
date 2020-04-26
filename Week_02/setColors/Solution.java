package setColors;

/**
 * https://leetcode-cn.com/problems/set-colors/
 *
 * @author David Liu
 */
public class Solution {

    // 双指针法: 让 0 都出现在数组的左边, 让 2 都出现在数组的右边
    // 时间复杂度: O(N)
    // 空间复杂度: O(1)
    public void setColors1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int p0 = 0, cur = 0, p2 = nums.length - 1;
        int t;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                t = nums[p0];
                nums[p0++] = nums[cur];
                nums[cur++] = t;
            } else if (nums[cur] == 2) {
                t = nums[p2];
                nums[p2--] = nums[cur];
                nums[cur] = t;
            } else cur++;
        }
    }
}
