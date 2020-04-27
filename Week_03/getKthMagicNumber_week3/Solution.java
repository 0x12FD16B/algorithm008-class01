package getKthMagicNumber_week3;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 *
 * @author David Liu
 */
public class Solution {
    // 解法一: 使用堆 + 集合
    // 时间复杂度: O(N*logk)
    // 空间复杂度: O(N)
    public int getKthMagicNumber(int k) {
        long[] prime = {3, 5, 7};
        Queue<Long> heap = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        Long num = 1L;
        for (int i = 0; i < k; i++) {
            num = heap.poll();
            for (long p : prime)
                if (!set.contains(num * p)) {
                    heap.offer(num * p);
                    set.add(num * p);
                }
        }

        return num.intValue();
    }

    // 解法二: 动态规划
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    public int getKthMagicNumber2(int k) {
        if (k <= 0) return 0;
        int[] res = new int[k];
        res[0] = 1;

        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < k; i++) {
            res[i] = Math.min(res[p3] * 3, Math.min(res[p5] * 5, res[p7] * 7));
            if (res[i] == res[p3] * 3) p3++;
            if (res[i] == res[p5] * 5) p5++;
            if (res[i] == res[p7] * 7) p7++;
        }

        return res[k - 1];
    }
}
