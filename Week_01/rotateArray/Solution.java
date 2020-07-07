package rotateArray;

/**
 * https://leetcode-cn.com/problems/rotate-array/
 *
 * @author David Liu
 */
public class Solution {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;

        int length = nums.length;
        k = k % nums.length;

        for (int startPos = 0, moveCount = 0; moveCount < length; startPos++) {
            int currentPos = startPos;
            int currentEle = nums[startPos];
            do {
                int destPos = (currentPos + k) % length;
                int t = currentEle;
                currentEle = nums[destPos];
                nums[destPos] = t;
                moveCount++;
                currentPos = destPos;
            } while (startPos != currentPos);
        }
    }

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        int length = nums.length;
        int[] dest = new int[length];
        for (int i = 0; i < length; i++) {
            dest[(i + k) % length] = nums[i];
        }

        System.arraycopy(dest, 0, nums, 0, length);
    }

}
