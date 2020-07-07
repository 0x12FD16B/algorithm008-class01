package burstBalloons;

import org.junit.Assert;
import org.junit.Test;

/**
 * burst balloons test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = {3, 1, 5, 8};
        int expect = 167;
        int actual = solution.maxCoins(nums);
        Assert.assertEquals(expect, actual);
    }
}
