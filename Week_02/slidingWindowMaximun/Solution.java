package slidingWindowMaximun;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @author David Liu
 */
public class Solution {

    // 解法一: 暴力法
    // 从前往后挪动滑动窗口, 每次获取窗口内的最大值得到结果
    // 时间复杂度: O(N * k)
    // 空间复杂度: O(N)
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) return nums;
        int length = nums.length;
        int[] res = new int[length - k + 1];
        int p = 0;
        for (int i = 0; i + k <= length; i++) {
            int max = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[p++] = max;
        }
        return res;
    }

    // 解法二: 双端队列
    // 空间复杂度: O(N)
    // 时间复杂度: O(N)
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int length = nums.length, p = 0;
        int[] res = new int[length - k + 1];

        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.offerLast(i);
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            if (i >= k - 1) res[p++] = nums[deque.peekFirst()];
        }

        return res;
    }

}
