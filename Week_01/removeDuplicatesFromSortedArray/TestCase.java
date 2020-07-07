package removeDuplicatesFromSortedArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * remove duplicates test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = {1, 1, 2};
        int[] expect = {1, 2};
        int i = solution.removeDuplicates(nums);
        int[] actual = new int[i];
        System.arraycopy(nums, 0, actual, 0, i);
        Assert.assertArrayEquals(expect, actual);
    }

    @Test
    public void case2() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] expect = {0, 1, 2, 3, 4};
        int i = solution.removeDuplicates(nums);
        int[] actual = new int[i];
        System.arraycopy(nums, 0, actual, 0, i);
        Assert.assertArrayEquals(expect, actual);
    }
}
