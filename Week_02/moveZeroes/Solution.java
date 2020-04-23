package moveZeroes;

/**
 * https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author David Liu
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int length = nums.length, p = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) nums[p++] = nums[i];
        }

        for (int i = p; i < length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
        }
    }
}
