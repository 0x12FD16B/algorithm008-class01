package permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 *
 * @author David Liu
 */
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();

        int length = nums.length;
        boolean[] used = new boolean[length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, length, 0, new ArrayList<>(), used, res);
        return res;
    }

    private void dfs(int[] nums, int length, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        // terminator
        if (depth == length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            if (used[i]) continue;
            // process current logic
            path.add(nums[i]);
            used[i] = true;
            // drill down
            dfs(nums, length, depth + 1, path, used, res);
            // revert current state
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
