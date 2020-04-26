package chouShuLcof;

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

    // 使用堆 + 集合
    // 时间复杂度: O(NlogN)
    // 空间复杂度: O(N)
    public int nthUglyNumber1(int n) {
        long[] prime = {2, 3, 5};
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.offer(1L);
        long num = 1;
        for (int i = 0; i < n; i++) {
            num = pq.poll();
            for (long p : prime) {
                if (!set.contains(p * num)) {
                    set.add(p * num);
                    pq.offer(p * num);
                }
            }
        }

        return (int) num;
    }

    // 动态规划
    public int nthUglyNumber2(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(res[p2] * 2, Math.min(res[p3] * 3, res[p5] * 5));
            if (res[i] == res[p2] * 2) p2++;
            if (res[i] == res[p3] * 3) p3++;
            if (res[i] == res[p5] * 5) p5++;
        }
        return res[n - 1];
    }
}
