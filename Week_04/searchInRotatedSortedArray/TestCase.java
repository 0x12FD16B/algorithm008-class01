package searchInRotatedSortedArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0, expect = 4;
        int actual = solution.search(nums, target);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 5, expect = 1;
        int actual = solution.search(nums, target);
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void case3() {
        int[] nums = {3, 1};
        int target = 1, expect = 1;
        int actual = solution.search(nums, target);
        Assert.assertEquals(expect, actual);
    }
}
