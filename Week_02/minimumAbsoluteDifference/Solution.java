package minimumAbsoluteDifference;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-difference/
 *
 * @author David Liu
 */
public class Solution {
    // 排序, 然后顺序遍历
    // 时间复杂度: O(NlogN)
    // 空间复杂度: O(N)
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int minAbs = Integer.MAX_VALUE;
        List<List<Integer>> res = new LinkedList<>();
        for (int p = 0, q = 1; p < len && q < len; p++, q++) {
            if (arr[q] - arr[p] < minAbs) {
                res.clear();
                res.add(Arrays.asList(arr[p], arr[q]));
                minAbs = arr[q] - arr[p];
            } else if (arr[q] - arr[p] == minAbs) res.add(Arrays.asList(arr[p], arr[q]));
        }

        return res;
    }
}
