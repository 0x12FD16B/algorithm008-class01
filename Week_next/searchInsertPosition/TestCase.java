package searchInsertPosition;

import org.junit.Assert;
import org.junit.Test;

/**
 * search-insert-position test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int expect = 2;
        Assert.assertEquals(solution.searchInsert(nums, target), expect);
    }

    @Test
    public void case2() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        int expect = 1;
        Assert.assertEquals(solution.searchInsert(nums, target), expect);
    }

    @Test
    public void case3() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int expect = 4;
        Assert.assertEquals(solution.searchInsert(nums, target), expect);
    }

    @Test
    public void case4() {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        int expect = 0;
        Assert.assertEquals(solution.searchInsert(nums, target), expect);
    }
}
