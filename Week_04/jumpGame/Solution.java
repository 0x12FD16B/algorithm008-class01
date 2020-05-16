package jumpGame;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author David Liu
 */
public class Solution {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (farthest >= i) farthest = Math.max(i + nums[i], farthest);
        }
        return farthest >= nums.length - 1;
    }
}
