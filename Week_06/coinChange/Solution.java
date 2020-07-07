package coinChange;

import java.util.Arrays;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/coin-change/
 *
 * @author David Liu
 */
public class Solution {

    // 使用 dp
    //  1. 分治(找重复子问题): amount 金额使用硬币最少的数量 = amount - C[k] 金额适用硬币最少的数量 + 1
    //  2. 状态数组: F[i]
    //  3. 状态转移方程 F[i] = Math.min(F[i - coins[0] ... F[i - coins[k]) + 1, (i - coins[k] >= 0)
    // 时间复杂度: O(n)
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    // 暴力递归
    // 时间复杂度: O(n ^ k) 指数级
    // 空间复杂度: O(n)
    private int coinChangeRecur(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = coinChangeRecur(coins, amount - coin);
            if (subRes == -1) continue;
            res = Math.min(res, 1 + subRes);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }


    // 带备忘录的递归: 画出该问题的递归树可以发现, 其实有很多递归要解决的问题是重复的
    // 时间复杂度: O(N)
    // 空间复杂度: O(N)
    private int coinChangeRecur(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) return memo.get(amount);
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subRes = coinChangeRecur(coins, amount - coin, memo);
            if (subRes == -1) continue;
            res = Math.min(res, subRes + 1);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo.put(amount, res);
        return res;
    }
}