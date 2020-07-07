package rotateArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * rotate array test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] expect = {5, 6, 7, 1, 2, 3, 4};
        solution.rotate2(nums, k);
        Assert.assertArrayEquals(nums, expect);
    }

    @Test
    public void case2() {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        int[] expect = {3, 99, -1, -100};
        solution.rotate2(nums, k);
        Assert.assertArrayEquals(nums, expect);

    }

}
