package jumpGame;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/jump-game
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean actual = solution.canJump(nums);
        Assert.assertTrue(actual);
    }

    @Test
    public void case2() {
        int[] nums = {3, 2, 1, 0, 4};
        boolean actual = solution.canJump(nums);
        Assert.assertFalse(actual);
    }

}
