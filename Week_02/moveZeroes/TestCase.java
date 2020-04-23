package moveZeroes;

import org.junit.Assert;
import org.junit.Test;

/**
 * move zeroes test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] expect = new int[]{1, 3, 12, 0, 0};
        solution.moveZeroes2(nums);
        Assert.assertArrayEquals(expect, nums);
    }
}
