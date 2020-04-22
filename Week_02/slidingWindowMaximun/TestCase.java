package slidingWindowMaximun;

import org.junit.Assert;
import org.junit.Test;

/**
 * sliding maximum window test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expect = new int[]{3, 3, 5, 5, 6, 7};
        int[] actual = solution.maxSlidingWindow(nums, k);
        Assert.assertArrayEquals(expect, actual);
    }
}
