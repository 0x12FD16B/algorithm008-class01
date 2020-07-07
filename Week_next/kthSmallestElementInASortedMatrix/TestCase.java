package kthSmallestElementInASortedMatrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * kthSmallest test case
 *
 * @author David Liu
 */
public class TestCase {

    private final Solution solution = new Solution();

    @Test
    public void case1() {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        Assert.assertEquals(solution.kthSmallest2(matrix, 8), 13);
    }
}
