package chouShuLcof_week03;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/chou-shu-lcof/
 *
 * @author David Liu
 */
public class Solution {

    // 解法一: 使用堆
    // 时间复杂度: O(NlogN)
    // 空间复杂度: O(N)
    public int nthUglyNumber1(int n) {
        if (n == 1) return 1;
        Queue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        long[] primes = {2, 3, 5};
        Long num = 1L;
        for (int i = 1; i <= n; i++) {
            num = heap.poll();
            for (long p : primes) {
                if (!set.contains(num * p)) {
                    set.add(num * p);
                    heap.offer(num * p);
                }
            }
        }
        return num.intValue();
    }

    // 解法二: 使用 DP
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int num = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (num == dp[p2] * 2) p2++;
            if (num == dp[p3] * 3) p3++;
            if (num == dp[p5] * 5) p5++;
            dp[i] = num;
        }
        return dp[n - 1];
    }
}
