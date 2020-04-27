package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author David Liu
 */
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = num + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(num, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum > 0) right--;
                else left++;
            }
        }

        return ans;

    }

}
