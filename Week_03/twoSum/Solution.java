package twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum
 *
 * @author David Liu
 */
public class Solution {

    // 解法一: 暴力法, 两重循环枚举结果
    // 时间复杂度: O(N^2)
    // 空间复杂度: O(1)
    public int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++)
            for (int j = i + 1; j < length; j++)
                if (nums[i] + nums[j] == target) return new int[]{i, j};

        return new int[0];
    }

    // 解法二: 两次遍历, 使用哈希表加快查询效率
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);

        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(c) && map.get(c) != i)
                return new int[]{i, map.get(c)};
        }

        return new int[0];
    }

    // 解法三: 一次遍历, 使用哈希表加快查询效率
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];
            if (map.containsKey(nums[i])) return new int[]{i, map.get(nums[i])};
            map.put(c, i);
        }

        return new int[0];
    }

}
