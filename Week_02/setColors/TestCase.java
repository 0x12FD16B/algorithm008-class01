package setColors;

import org.junit.Assert;
import org.junit.Test;

/**
 * set colors test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] expect = {0, 0, 1, 1, 2, 2};
        solution.setColors1(nums);
        Assert.assertArrayEquals(nums, expect);
    }

    @Test
    public void case2() {
        int[] nums = {2, 0, 2, 0, 1, 1};
        int[] expect = {0, 0, 1, 1, 2, 2};
        solution.setColors1(nums);
        Assert.assertArrayEquals(nums, expect);
    }

    @Test
    public void case3() {
        int[] nums = {2, 0, 1};
        int[] expect = {0, 1, 2};
        solution.setColors1(nums);
        Assert.assertArrayEquals(nums, expect);
    }
}
