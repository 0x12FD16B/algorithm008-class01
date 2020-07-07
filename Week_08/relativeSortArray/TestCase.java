package relativeSortArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * relative sort array test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        int[] expect = {2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19};
        Assert.assertArrayEquals(expect, solution.relativeSortArray(arr1, arr2));
    }

}
