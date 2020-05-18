package searchA2dMatrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * search-a-2d-matrix test case
 *
 * @author David Liu
 */
public class TestCase {
    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        Assert.assertTrue(solution.searchMatrix2(matrix, 3));
    }

    @Test
    public void case2() {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        Assert.assertFalse(solution.searchMatrix2(matrix, 13));
    }

    @Test
    public void case3() {
        int[][] matrix = {
                {1, 3}
        };
        Assert.assertTrue(solution.searchMatrix2(matrix, 3));
    }
}
