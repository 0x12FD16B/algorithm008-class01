package coinChange;

import org.junit.Assert;
import org.junit.Test;

/**
 * coin change test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int expect = 3;
        int actual = solution.coinChange(coins, amount);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case2() {
        int[] coins = {2};
        int amount = 3;
        int expect = -1;
        int actual = solution.coinChange(coins, amount);
        Assert.assertEquals(expect, actual);
    }
}
