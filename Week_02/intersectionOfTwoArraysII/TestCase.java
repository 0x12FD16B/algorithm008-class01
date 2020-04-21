package intersectionOfTwoArraysII;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * intersection-of-two-arrays-ii test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        int[] expect = {2, 2};
        int[] intersect = solution.intersect4(nums1, nums2);
        assertEquals("case1", Arrays.toString(expect), Arrays.toString(intersect));
    }

    @Test
    public void case2() {
        int[] nums1 = {4, 9, 5}, nums2 = {9, 4, 9, 8, 4};
        int[] expect = {4, 9};
        int[] intersect = solution.intersect4(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
        assertEquals("case2", Arrays.toString(expect), Arrays.toString(intersect));
    }

    @Test
    public void case3() {
        int[] nums1 = {1, 2}, nums2 = {1, 1};
        int[] expect = {1};
        int[] intersect = solution.intersect4(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
        assertEquals("case3", Arrays.toString(expect), Arrays.toString(intersect));
    }

}
