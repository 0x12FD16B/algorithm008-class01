package twoSumIIInputArrayIsSorted;

import org.junit.Assert;
import org.junit.Test;

/**
 * two-sum-ii-input-array-is-sorted test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] numbers = {2, 7, 9, 11};
        int target = 9;
        int[] expect = {1, 2};
        Assert.assertArrayEquals(expect, solution.twoSum1(numbers, target));
    }
}
