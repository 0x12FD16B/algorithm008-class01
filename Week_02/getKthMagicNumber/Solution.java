package getKthMagicNumber;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 *
 * @author David Liu
 */
public class Solution {

    // 解法一: 使用堆 + 集合
    // 时间复杂度: O(K)
    // 空间复杂度: O(K)
    public int getKthMagicNumber1(int k) {
        long[] prime = new long[]{3, 5, 7};
        PriorityQueue<Long> queue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        queue.offer(1L);
        long num = 1;
        for (int i = 0; i < k; i++) {
            num = queue.poll();
            for (long p : prime) {
                if (!set.contains(num * p)) {
                    queue.offer(num * p);
                    set.add(num * p);
                }
            }
        }
        return (int) num;
    }

    // 解法二: 动态规划
    // 1. 定义三个指针p3,p5,p7，p3指向的数字永远乘3，p5指向的数字永远乘5，p7指向的数字永远乘7
    // 2. 初始化所有指针都指向第一个丑数，即1
    // 3. 从 dp[p3]*3, dp[p5]*5, dp[p7]*7 选取最小的一个数字，作为新的丑数。这边新的丑数就是3*dp[p3]=3*1=3，然后p3++
    // 4. 此时p5和p7指向第1个丑数，p3指向第2个丑数。然后重复上一步
    public int getKthMagicNumber2(int k) {
        int[] res = new int[k];
        int p3 = 0, p5 = 0, p7 = 0;
        res[0] = 1;
        for (int i = 1; i < k; i++) {
            res[i] = Math.min(res[p3] * 3, Math.min(res[p5] * 5, res[p7] * 7));
            if (res[i] == res[p3] * 3) p3++;
            if (res[i] == res[p5] * 5) p5++;
            if (res[i] == res[p7] * 7) p7++;
        }

        return res[k - 1];

    }
}
