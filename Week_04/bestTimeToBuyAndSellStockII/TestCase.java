package bestTimeToBuyAndSellStockII;

import org.junit.Assert;
import org.junit.Test;

/**
 * best-time-to-buy-and-sell-stock-ii test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expect = 7;
        int actual = solution.maxProfit(prices);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case2() {
        int[] prices = {1, 2, 3, 4, 5};
        int expect = 4;
        int actual = solution.maxProfit(prices);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case3() {
        int[] prices = {5, 4, 3, 2, 1};
        int expect = 0;
        int actual = solution.maxProfit(prices);
        Assert.assertEquals(expect, actual);
    }
}
