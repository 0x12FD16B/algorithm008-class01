package findRotatedSortedArrayRotatePoint;

import org.junit.Assert;
import org.junit.Test;

/**
 * 寻找旋转有序数组的旋转点测试样例
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = {4, 5, 6, 7, 8, 0, 1, 2};
        int expect = 5;
        int actual = solution.findRotatedPoint(nums);
        Assert.assertEquals(expect, actual);
    }
}
